package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.ArrayType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.Logger;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractArray<ArrayKind extends Expression> implements Expression {

	/**
	 * AST node that represents the expression whose result is an array.
	 */
	protected ArrayKind array;

	/**
	 * AST node that represents the expression whose result is an integer value used
	 * to index the array.
	 */
	protected AccessibleExpression index;

	/**
	 * Construction for the implementation of an array element access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param _array Abstract Syntax Tree for the array part in an array element
	 *               access expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element
	 *               access expression.
	 */
	public AbstractArray(ArrayKind _array, AccessibleExpression _index) {
		this.array = _array;
		this.index = _index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (this.array + "[ " + this.index + " ]");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		// Collect and partially resolve the array and index expressions
		boolean arrayResolved = this.array.collectAndPartialResolve(_scope);
		boolean indexResolved = this.index.collectAndPartialResolve(_scope);
		// Return true if both are successfully resolved
		return arrayResolved && indexResolved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		// Résout le tableau et l'indice
		boolean arrayResolved = this.array.completeResolve(_scope);
		boolean indexResolved = this.index.completeResolve(_scope);

		if (!arrayResolved) {
			Logger.error("Error: Failed to resolve array in AbstractArray.");
		}
		if (!indexResolved) {
			Logger.error("Error: Failed to resolve index in AbstractArray.");
		}

		return arrayResolved && indexResolved;
	}

	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	@Override
	public Type getType() {
		// Vérifie si le type de l'expression du tableau est un type de tableau
		Type arrayType = this.array.getType();
		if (arrayType instanceof ArrayType) {
			// Retourne le type des éléments du tableau
			return ((ArrayType) arrayType).getType();
		} else {
			throw new SemanticsUndefinedException("The type is not an array.");
		}
	}

}