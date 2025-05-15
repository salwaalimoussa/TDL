/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Abstract Syntax Tree node for a variable declaration instruction.
 * 
 * @author Marc Pantel
 *
 */
public class VariableDeclaration implements Declaration, Instruction {

	/**
	 * Name of the declared variable.
	 */
	protected String name;

	/**
	 * AST node for the type of the declared variable.
	 */
	protected Type type;

	/**
	 * AST node for the initial value of the declared variable.
	 */
	protected Expression value;

	/**
	 * Address register that contains the base address used to store the declared
	 * variable.
	 */
	protected Register register;

	/**
	 * Offset from the base address used to store the declared variable
	 * i.e. the size of the memory allocated to the previous declared variables
	 */
	protected int offset;
	// on a ajoute cela

	/**
	 * Creates a variable declaration instruction node for the Abstract Syntax Tree.
	 * 
	 * @param _name  Name of the declared variable.
	 * @param _type  AST node for the type of the declared variable.
	 * @param _value AST node for the initial value of the declared variable.
	 */
	public VariableDeclaration(String _name, Type _type, Expression _value) {
		this.name = _name;
		this.type = _type;
		this.value = _value;
	}

	public VariableDeclaration(String name, Type type, int offset) {
		this.name = name;
		this.type = type;
		this.offset = offset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.name + " = " + this.value + ";\n";
	}

	/**
	 * Synthesized semantics attribute for the type of the declared variable.
	 * 
	 * @return Type of the declared variable.
	 */
	public Type getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Synthesized semantics attribute for the register used to compute the address
	 * of the variable.
	 * 
	 * @return Register used to compute the address where the declared variable will
	 *         be stored.
	 */
	public Register getRegister() {
		return this.register;
	}

	/**
	 * Synthesized semantics attribute for the offset used to compute the address of
	 * the variable.
	 * 
	 * @return Offset used to compute the address where the declared variable will
	 *         be stored.
	 */
	public int getOffset() {
		return this.offset;
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
		if (_scope.accepts(this)) {
			_scope.register(this); // Ajouter la déclaration à la table des symboles
			return true;
		} else {
			Logger.error("Variable " + this.getName() + " is already declared in this scope.");
			return false;
		}
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		throw new SemanticsUndefinedException(
				"Semantics collect is undefined in VariableDeclaration with FunctionDeclaration context.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return this.value.completeResolve(_scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		// Récupérer le type de la valeur assignée à la variable
		// Exemple : si la déclaration est "int x = 5;", alors valueType sera "int".
		Type valueType = this.value.getType();

		// Vérifier si le type de la valeur est compatible avec le type déclaré
		// Exemple : si la déclaration est "int x = 5;", this.type est "int" et
		// valueType est "int".
		if (this.type.equalsTo(valueType)) {
			return true; // Les types correspondent, la déclaration est valide.
		} else {
			// En cas d'incompatibilité, enregistrer une erreur et retourner false
			// Exemple : si la déclaration est "int x = 'string';", this.type est "int" et
			// valueType est "String".
			Logger.error("Type mismatch in variable declaration: expected " + this.type + ", but found " + valueType);
			return false; // Les types ne correspondent pas, la déclaration est invalide.
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register,
	 * int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		// Mémorise où sera stockée la variable
		this.register = _register;
		this.offset = _offset;

		// Retourne l’offset suivant (décalé de la taille de la variable)
		return _offset + this.type.length();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		// Generate value code
		fragment.append(this.value.getCode(_factory));

		// Store value
		fragment.add(_factory.createStore(register, offset, type.length()));

		return fragment;
	}

}