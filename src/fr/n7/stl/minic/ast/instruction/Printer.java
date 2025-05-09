/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a printer instruction.
 * 
 * @author Marc Pantel
 *
 */
public class Printer implements Instruction {

	protected Expression parameter;

	public Printer(Expression _value) {
		this.parameter = _value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "print " + this.parameter + ";\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		// Vérifie si l'expression (parameter) peut être collectée et partiellement
		// résolue
		return this.parameter.collectAndPartialResolve(_scope);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		return this.collectAndPartialResolve(_scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		// Vérifie si l'expression (parameter) peut être complètement résolue
		return this.parameter.completeResolve(_scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		// Vérifie si le type de l'expression est valide
		if (this.parameter.getType() == null) {
			Logger.error("The expression to print has no type.");
			return false;
		}
		return true; // Accepte tous les types pour l'instant
	}

	//si on veut pas accepter tous les types, on peut faire un if else
	/*@Override
	public boolean checkType() {
		Type type = this.parameter.getType();
		if (type == null) {
			Logger.error("The expression to print has no type.");
			return false;
		}
		if (!(type.equalsTo(AtomicType.IntegerType)
			|| type.equalsTo(AtomicType.BooleanType)
			|| type.equalsTo(AtomicType.CharacterType)
			|| type.equalsTo(AtomicType.StringType))) {
			Logger.error("Type " + type + " is not printable.");
			return false;
		}
		return true;
	}*/


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register,
	 * int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return _offset;  // Pas d'allocation nécessaire
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		// Générer le code pour évaluer l'expression
		fragment.append(this.parameter.getCode(_factory));
		
		Type type = this.parameter.getType();

		if (type.equalsTo(AtomicType.IntegerType)) {
			fragment.add(Library.IOut);
		} else if (type.equalsTo(AtomicType.BooleanType)) {
			fragment.add(Library.BOut);
		} else if (type.equalsTo(AtomicType.CharacterType)) {
			fragment.add(Library.COut);
		} else {
			fragment.add(Library.SOut);  // chaîne ou autre
		}

		return fragment;
	}


}
