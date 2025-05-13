/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

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
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class Iteration implements Instruction {

	protected Expression condition;
	protected Block body;

	public Iteration(Expression _condition, Block _body) {
		this.condition = _condition;
		this.body = _body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "while (" + this.condition + " )" + this.body;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
    boolean conditionResolved = this.condition.collectAndPartialResolve(_scope);
    boolean bodyResolved = this.body.collectAndPartialResolve(_scope);
    return conditionResolved && bodyResolved;
}
	
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		throw new SemanticsUndefinedException( "Semantics collect is undefined in Iteration.");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
    boolean conditionResolved = this.condition.completeResolve(_scope);
    boolean bodyResolved = this.body.completeResolve(_scope);
    return conditionResolved && bodyResolved;
}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
public boolean checkType() {
    if (!this.condition.getType().equalsTo(AtomicType.BooleanType)) {
        Logger.error("The condition of the while loop must be of type boolean.");
        return false;
    }
    return this.body.checkType();
}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.body.allocateMemory(_register, _offset);
		return _offset;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
public Fragment getCode(TAMFactory _factory) {
    Fragment fragment = _factory.createFragment();
    
    String startLabel = "while_start_" + _factory.createLabelNumber();
    String endLabel = "while_end_" + _factory.createLabelNumber();
    
    // Add initial JUMP to make fragment non-empty
    fragment.add(_factory.createJump(startLabel));
    
    // Loop body
    fragment.append(this.body.getCode(_factory));
    
    // Start label (now safe to add as fragment has content)
    fragment.addSuffix(startLabel);
    
    // Condition evaluation
    fragment.append(this.condition.getCode(_factory));
    fragment.add(_factory.createJumpIf("while_body_" + startLabel, 1));
    
    // End label
    fragment.addSuffix(endLabel);
    
    return fragment;
}
}
