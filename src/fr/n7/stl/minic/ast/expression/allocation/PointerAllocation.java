/**
 * 
 */
package fr.n7.stl.minic.ast.expression.allocation;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class PointerAllocation implements AccessibleExpression, AssignableExpression {

	protected Type element;

	public PointerAllocation(Type _element) {
		this.element = _element;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "new " + this.element; 
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		return this.size.collectAndPartialResolve(_scope);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		// Ensures the element type is fully resolved
		boolean elementOk = this.element.completeResolve(_scope);
		return elementOk;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
	
		if (this.element == null) {
			return null;
		}
		if (!this.element.isType()) {
			return null;
		}

		// Creates and returns a new PointerType wrapping the element type
		return new PointerType(this.element);

	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment code = _factory.createFragment();
		// Allocate space for the pointer (1 word)
		code.add(_factory.createPush(1));
		// Call HEAPALLOC to allocate memory
		code.add(_factory.createHEAPALLOC());
		return code;
	}

}
