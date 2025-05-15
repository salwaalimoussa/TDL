/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * 
 * @author Marc Pantel
 *
 */
public class PointerType implements Type {

	protected Type element;

	public PointerType(Type _element) {
		this.element = _element;
	}

	public Type getPointedType() {
		return this.element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	/*
	 * @Override
	 * public boolean equalsTo(Type _other) {
	 * throw new
	 * SemanticsUndefinedException("Semantics equalsTo undefined in PointerType.");
	 * }
	 */

	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof PointerType) {
			PointerType otherPointer = (PointerType) _other;
			return this.element.equalsTo(otherPointer.getPointedType());
		}
		return false;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */

	 @Override
	 public boolean compatibleWith(Type _other) {
		 if (_other instanceof PointerType) {
			 return this.element.compatibleWith(((PointerType) _other).getPointedType());
		 } else {
			 return false;
		 }
	 }
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		Type _result;
		if (_other instanceof PointerType) {
			_result = new PointerType(this.element.merge(((PointerType) _other).element));
		} else {
			_result = AtomicType.ErrorType;
		}
		return _result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		// Retourne la taille d'un pointeur en mémoire (par exemple, 4 octets pour 32
		// bits)
		return 8; // Ajustez cette valeur en fonction de votre architecture cible
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.element + " *)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return this.element.completeResolve(_scope);
	}

}