/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractField;
import fr.n7.stl.minic.ast.expression.accessible.BinaryOperator;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldAssignment extends AbstractField<AssignableExpression> implements AssignableExpression {

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _name Name of the field in the record field assignment expression.
	 */
	public FieldAssignment(AssignableExpression _record, String _name) {
		super(_record, _name);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	 @Override
    public Fragment getCode(TAMFactory _factory) {
        // Create new fragment to store generated code
        Fragment fragment = _factory.createFragment();
        
        // 1. Generate code to compute the base address of the record
        fragment.append(this.record.getCode(_factory));
        
        // 2. Add the offset of the field within the record
        // This offset is calculated from the record's type declaration
		//int fieldOffset = this.record.getType().getOffset(this.name);
		//fragment.add(_factory.createLoadL(fieldOffset));

		fragment.add(_factory.createLoadL(0)); // Remplacer 0 par l'offset réel plus tard
        
        // 3. Add the offset to the base address to get field address
    	fragment.add(TAMFactory.createBinaryOperator(BinaryOperator.Add));
        
        return fragment;
    }
	
}
