/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractArray;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.accessible.BinaryOperator;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a cell in an array.
 * @author Marc Pantel
 */
public class ArrayAssignment extends AbstractArray<AssignableExpression> implements AssignableExpression {

	/**
	 * Construction for the implementation of an array element assignment expression Abstract Syntax Tree node.
	 * @param _array Abstract Syntax Tree for the array part in an array element assignment expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element assignment expression.
	 */
	public ArrayAssignment(AssignableExpression _array, AccessibleExpression _index) {
		super(_array, _index);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.ArrayAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		// Create a new code fragment to store the generated code
		Fragment fragment = _factory.createFragment();

		// 1. Generate code to compute the base address of the array
		fragment.append(this.array.getCode(_factory));

		// 2. Generate code to compute the index value
		fragment.append(this.index.getCode(_factory));

		// 3. Load array element size to multiply with index
		// This gives us the offset from base address
		fragment.add(_factory.createLoadL(this.array.getType().length()));
		
		// 4. Multiply index by element size to get actual offset
		fragment.add(TAMFactory.createBinaryOperator(BinaryOperator.Multiply));

		// 5. Add the offset to base address to get target address
		fragment.add(TAMFactory.createBinaryOperator(BinaryOperator.Add));

		// Return the complete fragment containing array assignment code
		return fragment;
	}

	@Override
	public String getName() {
		return "ArrayAssignment";
	}
	
}
