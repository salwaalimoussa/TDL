/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import org.antlr.v4.tool.LabelType;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional
 * instruction.
 * 
 * @author Marc Pantel
 *
 */
public class Conditional implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Block elseBranch;

	public Conditional(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = _else;
	}

	public Conditional(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch
				+ ((this.elseBranch != null) ? (" else " + this.elseBranch) : "");
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
		boolean conditionResolved = this.condition.collectAndPartialResolve(_scope);
		boolean thenResolved = this.thenBranch.collectAndPartialResolve(_scope);
		boolean elseResolved = (this.elseBranch != null) ? this.elseBranch.collectAndPartialResolve(_scope) : true;
		return conditionResolved && thenResolved && elseResolved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
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
    boolean conditionResolved = this.condition.completeResolve(_scope);
    boolean thenResolved = this.thenBranch.completeResolve(_scope);
    boolean elseResolved = (this.elseBranch != null) ? this.elseBranch.completeResolve(_scope) : true;
    return conditionResolved && thenResolved && elseResolved;
}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean ok1 = this.thenBranch.checkType();
		boolean ok2 = (this.elseBranch != null) ? this.elseBranch.checkType() : true;
		boolean ok3 = this.condition.getType().equals(AtomicType.BooleanType);
		if (!ok3) {
			Logger.error("Condition of the conditional is not a boolean type.");
		}
		return ok1 && ok2 && ok3;
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
		// On alloue la mémoire dans les deux branches
		this.thenBranch.allocateMemory(_register, _offset);
		if (this.elseBranch != null) {
			this.elseBranch.allocateMemory(_register, _offset);
		}
		return _offset; // L'offset ne change pas en dehors du bloc
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		// Crée deux labels uniques
		String labelElse = "else_" + _factory.createLabelNumber();
    	String labelEnd = "endif_" + _factory.createLabelNumber();

		// Génère le code de la condition
		fragment.append(this.condition.getCode(_factory));

		// Si condition fausse, saut vers else (ou end si pas de else)
		fragment.add(_factory.createJumpIf(labelElse, 0)); // 0 = faux

		// Code de la branche then
		fragment.append(this.thenBranch.getCode(_factory));

		// Saut inconditionnel vers la fin si y a un else
		if (this.elseBranch != null) {
			fragment.add(_factory.createJump(labelEnd));

			// Label du else
			fragment.addSuffix(labelElse);
			fragment.append(this.elseBranch.getCode(_factory));
		}

		// Fin de l'instruction
		fragment.addSuffix(labelEnd);

		return fragment;
	}


}
