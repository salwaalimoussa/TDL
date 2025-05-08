/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for an array type.
 * 
 * @author Marc Pantel
 *
 */
public class Assignment implements Instruction, Expression {

	protected Expression value;
	protected AssignableExpression assignable;
	// ona ajoute cela pour travailler avec logger

	/**
	 * Create an assignment instruction implementation from the assignable
	 * expression
	 * and the assigned value.
	 * 
	 * @param _assignable Expression that can be assigned a value.
	 * @param _value      Value assigned to the expression.
	 */
	public Assignment(AssignableExpression _assignable, Expression _value) {
		this.assignable = _assignable;
		this.value = _value;
		/*
		 * This attribute will be assigned to the appropriate value by the resolve
		 * action
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.assignable + " = " + this.value.toString() + ";\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean assignableResolved = this.assignable.collectAndPartialResolve(_scope);
		boolean valueResolved = this.value.collectAndPartialResolve(_scope);
		return assignableResolved && valueResolved;
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
	 * .HierarchicalScope)
	 */
	@Override
public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
    // Vérifier si la variable assignée est connue dans la portée
    Declaration decl = _scope.get(this.assignable.getName());
    boolean ok1 = (decl != null);

    if (!ok1) {
        Logger.error("Error: Symbol not found in scope for " + this.assignable.getName());
    } else if (decl instanceof ConstantDeclaration) {
        Logger.error("Error: Cannot assign to a constant: " + this.assignable.getName());
        ok1 = false;
    }

    // Résoudre l'expression assignable et la valeur
    boolean ok2 = this.assignable.completeResolve(_scope);
    boolean ok3 = this.value.completeResolve(_scope);

    return ok1 && ok2 && ok3;
}
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.expression.Expression#getType()
	 */
	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in Assignment.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		// throw new SemanticsUndefinedException("Semantics checkType is undefined in
		// Assignment.");
		Type assignableType = this.assignable.getType();
		Type valueType = this.value.getType();
		if (assignableType.equals(valueType)) {
			return true;
		} else {
			Logger.error("Type mismatch in assignment: expected " + assignableType + ", but found " + valueType);
			return false;
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
		throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in Assignment.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in Assignment.");
	}

}
