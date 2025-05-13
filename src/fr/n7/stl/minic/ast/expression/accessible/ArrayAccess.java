/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractArray;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing an array
 * element.
 * 
 * @author Marc Pantel
 *
 */
public class ArrayAccess extends AbstractArray<AccessibleExpression> implements AccessibleExpression {

	/**
	 * Construction for the implementation of an array element access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param _array Abstract Syntax Tree for the array part in an array element
	 *               access expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element
	 *               access expression.
	 */
	public ArrayAccess(AccessibleExpression _array, AccessibleExpression _index) {
		super(_array, _index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override

	public Fragment getCode(TAMFactory _factory) {
		Fragment code = _factory.createFragment();

		// Générer le code pour l'adresse de l'élément du tableau
		code.append(this.array.getCode(_factory)); // Code pour l'adresse de la base du tableau
		code.append(this.index.getCode(_factory)); // Code pour l'index
		code.add(_factory.createLoadL(this.array.getType().length())); // Taille d'un élément

		// Utiliser BinaryOperator.Multiply pour calculer l'offset
		code.add(TAMFactory.createBinaryOperator(BinaryOperator.Multiply)); // Calcul de l'offset

		// Utiliser BinaryOperator.Add pour calculer l'adresse finale
		code.add(TAMFactory.createBinaryOperator(BinaryOperator.Add)); // Adresse de l'élément

		return code;
	}

}
