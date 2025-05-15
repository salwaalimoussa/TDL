package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.RecordType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.util.Logger;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractField<RecordKind extends Expression> implements Expression {

	protected RecordKind record;
	protected String name;
	protected FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param _record Abstract Syntax Tree for the record part in a record field
	 *                access expression.
	 * @param _name   Name of the field in the record field access expression.
	 */
	public AbstractField(RecordKind _record, String _name) {
		this.record = _record;
		this.name = _name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.record + "." + this.name;
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
		// On délègue simplement à l'expression record : aucune déclaration locale ici
		return this.record.collectAndPartialResolve(_scope);
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
		// 1. Résoudre complètement l'expression record
		if (!this.record.completeResolve(_scope)) {
			return false; // erreur déjà loggée par l'expression
		}

		// 2. Récupérer le type de l'expression record
		Type recordType = this.record.getType();

		// 3. Déréférencer les alias (typedef)
		while (recordType instanceof NamedType) {
			recordType = ((NamedType) recordType).getType();
		}

		// 4. Vérifier que le type est un RecordType
		if (!(recordType instanceof RecordType)) {
			Logger.error("Attempting to access field '" + this.name + "' of a non-record type " + recordType);
			return false;
		}

		// 5. Rechercher la déclaration de champ correspondante
		FieldDeclaration f = ((RecordType) recordType).get(this.name);
		if (f == null) {
			Logger.error("Field '" + this.name + "' is not defined in record type " + recordType);
			return false;
		}

		// 6. Stocker la déclaration pour les étapes suivantes
		this.field = f;
		return true;
	}

	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	@Override
	public Type getType() {
		if (this.field != null) {
			return this.field.getType();
		}
		// Si la résolution n'est pas encore faite, on renvoie une erreur typée pour
		// éviter NPE
		Logger.error("getType called on AbstractField before complete resolution for field '" + this.name + "'.");
		return AtomicType.ErrorType;
	}

}