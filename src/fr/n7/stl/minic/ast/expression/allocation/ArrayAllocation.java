/**
 * 
 */
package fr.n7.stl.minic.ast.expression.allocation;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.accessible.BinaryOperator;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.ArrayType;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.PointerType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class ArrayAllocation implements AccessibleExpression, AssignableExpression {

	protected Type element;
	protected Expression size;

	public ArrayAllocation(Type _element, Expression _size) {
		this.element = _element;
		this.size = _size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "new " + this.element + "[ " + this.size + " ]"; 
	}

	
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		// This method is part of the first pass semantic analysis
		// here we need to collect and resolve the size expression
		return this.size.collectAndPartialResolve(_scope);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		// Part of second pass semantic analysis
    	// Resolve the element type (e.g., checking if 'int' is a valid type)
        boolean elementOk = this.element.completeResolve(_scope);
		// Resolve the size expression (e.g., checking if variables in size expression exist)
        boolean sizeOk = this.size.completeResolve(_scope);
        
        // Both must be valid for array allocation to be correct
        return elementOk && sizeOk;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		// First verify that size expression is an integer
		Type sizeType = this.size.getType();
		if (!sizeType.compatibleWith(AtomicType.IntegerType)) {
			throw new SemanticsUndefinedException(
				"Array size must be an integer, found: " + sizeType);
		}

		// Verify that element type is valid
		if (this.element == null) {
			throw new SemanticsUndefinedException("Array element type cannot be null");
		}

		// Handle different possible element types
		if (this.element.equals(AtomicType.IntegerType)) {
			return new ArrayType(AtomicType.IntegerType);
		} else if (this.element.equals(AtomicType.BooleanType)) {
			return new ArrayType(AtomicType.BooleanType);
		} else if (this.element.equals(AtomicType.CharacterType)) {
			return new ArrayType(AtomicType.CharacterType);
		} else if (this.element.equals(AtomicType.StringType)) {
			return new ArrayType(AtomicType.StringType);
		} else if (this.element.equals(AtomicType.FloatingType)) {
			return new ArrayType(AtomicType.FloatingType);
		} else if (this.element instanceof ArrayType) {
			// Handle multi-dimensional arrays
			return new ArrayType(this.element);
		} else if (this.element instanceof PointerType) {
			// Handle arrays of pointers
			return new ArrayType(this.element);
		}

		// If we get here, it's an unsupported type
		throw new SemanticsUndefinedException(
			"Unsupported array element type: " + this.element);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
        
        // Generate code for computing array size
        fragment.append(this.size.getCode(_factory));
        
        // Push element size onto stack and multiply
        fragment.add(_factory.createLoadL(this.element.length()));
        
		fragment.add(TAMFactory.createBinaryOperator(BinaryOperator.Multiply));
        // Allocate required memory on heap
		fragment.add(Library.MAlloc);

        return fragment;
	}

	@Override
	public String getName() {
		return "ArrayAllocation";
	}

}
