package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.PointerType;
import fr.n7.stl.minic.ast.type.Type;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractPointer<PointerKind extends Expression> implements Expression {

	/**
	 * AST node that represents an expression whose value is a pointer.
	 */
	protected PointerKind pointer;

	/**
	 * Construction for the implementation of a pointer content access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param _pointer Abstract Syntax Tree for the pointer expression in a pointer
	 *                 content access expression.
	 */
	public AbstractPointer(PointerKind _pointer) {
		this.pointer = _pointer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(*" + this.pointer + ")";
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
		// Résout l'expression sous-jacente du pointeur
		return this.pointer.collectAndPartialResolve(_scope);
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
		// Résout complètement l'expression sous-jacente du pointeur
		return this.pointer.completeResolve(_scope);
	}

	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	@Override
	public Type getType() {
		// Vérifie si le type du pointeur est un PointerType
		Type pointerType = this.pointer.getType();
		if (pointerType instanceof PointerType) {
			return ((PointerType) pointerType).getPointedType();
		} else {
			throw new SemanticsUndefinedException("The type is not a pointer.");
		}
	}

}