/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract Syntax Tree node for a function call expression.
 * 
 * @author Marc Pantel
 *
 */
public class FunctionCall implements AccessibleExpression {

	/**
	 * Name of the called function.
	 * TODO : Should be an expression.
	 */
	protected String name;

	/**
	 * Declaration of the called function after name resolution.
	 * TODO : Should rely on the VariableUse class.
	 */
	protected FunctionDeclaration function;

	/**
	 * List of AST nodes that computes the values of the parameters for the function
	 * call.
	 */
	protected List<AccessibleExpression> arguments;

	/**
	 * @param _name      : Name of the called function.
	 * @param _arguments : List of AST nodes that computes the values of the
	 *                   parameters for the function call.
	 */
	public FunctionCall(String _name, List<AccessibleExpression> _arguments) {
		this.name = _name;
		this.function = null;
		this.arguments = _arguments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = ((this.function == null) ? this.name : this.function) + "( ";
		Iterator<AccessibleExpression> _iter = this.arguments.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
		}
		while (_iter.hasNext()) {
			_result += " ," + _iter.next();
		}
		return _result + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		Declaration d = _scope.get(this.name);
		boolean result = true;

		if (d instanceof FunctionDeclaration) {
			this.function = (FunctionDeclaration) d;

			// Vérifie que le nombre d'arguments correspond au nombre de paramètres
			if (this.arguments.size() != this.function.getParameters().size()) {
				Logger.error("Incorrect number of arguments for function " + this.name + ".");
				return false;
			}

			// Résolution partielle des arguments
			for (AccessibleExpression arg : this.arguments) {
				result = result && arg.collectAndPartialResolve(_scope);
			}

			return result;

		} else {
			Logger.error("The function identifier " + this.name + " is not defined or is not a function.");
			this.function = null;
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		// 1. Resolve function declaration
		Declaration declaration = _scope.get(this.name);
		if (declaration == null || !(declaration instanceof FunctionDeclaration)) {
			Logger.error("Function " + this.name + " is not defined.");
			return false;
		}
		this.function = (FunctionDeclaration) declaration;

		// 2. Resolve arguments
		boolean result = true;
		for (AccessibleExpression arg : this.arguments) {
			result = result && arg.completeResolve(_scope);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		if (this.function != null) {
			return this.function.getType();
		} else {
			Logger.error("Function " + this.name + " is not declared.");
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		// 1. Generate code for arguments in reverse order
		for (int i = this.arguments.size() - 1; i >= 0; i--) {
			fragment.append(this.arguments.get(i).getCode(_factory));
		}

		// 2. Call function
		fragment.add(_factory.createCall(this.name, Register.LB));

		return fragment;
	}

}
