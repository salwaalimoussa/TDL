/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractIdentifier;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a
 * variable.
 * 
 * @author Marc Pantel
 *
 */
public class VariableAssignment extends AbstractIdentifier implements AssignableExpression {

	protected VariableDeclaration declaration;

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * 
	 * @param _name Name of the assigned variable.
	 */
	public VariableAssignment(String _name) {
		super(_name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.AbstractIdentifier#collect(fr.n7.stl.block.ast
	 * .scope.HierarchicalScope)
	 */
	// dyal declaration des variables katchuf wach variable name kayn endna f scope
	// li huwa table de symbole dyalna si oui katakhd declaration dyalo u katchuf
	// wach
	// declaration dyalo variable declaration sinon katrja3 erreur
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		if (((HierarchicalScope<Declaration>) _scope).knows(this.name)) {
			Declaration _declaration = _scope.get(this.name);
			if (_declaration instanceof VariableDeclaration) {
				this.declaration = ((VariableDeclaration) _declaration);
				return true;
			} else {
				Logger.error("The declaration for " + this.name + " is of the wrong kind.");
				return false;
			}
		} else {
			Logger.error("The identifier " + this.name + " has not been found.");
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.AbstractIdentifier#resolve(fr.n7.stl.block.ast
	 * .scope.HierarchicalScope)
	 */
	// dima katkhd declaration dyal variable li kayn f scope u katrja3 true hit
	// deja kat3rf wach variable kayn f scope u wach declaration dyalo variable b
	// methode lwla
	/*
	 * @Override
	 * public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
	 * // Check if variable declaration exists and is valid
	 * if (this.declaration == null) {
	 * Logger.error("Variable " + this.name + " has not been declared.");
	 * return false;
	 * }
	 * 
	 * // Check if variable type is resolved
	 * if (this.declaration.getType() == null) {
	 * Logger.error("Type of variable " + this.name + " could not be resolved.");
	 * return false;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * return true;
	 * }
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		if (_scope.knows(this.name)) {
			Declaration declaration = _scope.get(this.name);
			if (declaration instanceof VariableDeclaration) {
				this.declaration = (VariableDeclaration) declaration;
				return true;
			} else {
				Logger.error("The declaration for " + this.name + " is of the wrong kind.");
				return false;
			}
		} else {
			Logger.error("Variable " + this.name + " has not been declared.");
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getType()
	 */
	@Override
	public Type getType() {
		return this.declaration.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		// Load the address of the variable
		// For a variable assignment, we need its address where the value will be stored
		fragment.add(_factory.createLoadA(
				this.declaration.getRegister(), // Register where variable is stored
				this.declaration.getOffset() // Offset within the register
		));

		// Store value at address
		fragment.add(_factory.createStoreI(this.declaration.getType().length()));

		return fragment;
	}

	// on a ajoute cela pour que la classe assignement fonctionne pour le tp2 et on
	// a modifie le fichier expressionassignable
	@Override
	public String getName() {
		return this.name;
	}

}
