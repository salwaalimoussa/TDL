/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a return instruction.
 * @author Marc Pantel
 *
 */
public class Return implements Instruction {

	protected Expression value;
	
	protected FunctionDeclaration function;

	public Return(Expression _value) {
		this.value = _value;
		this.function = null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ((this.function != null)?("// Return in function : " + this.function.getName() + "\n"):"") + "return " + this.value + ";\n";
	}
	public Expression getValue() {
		return this.value;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
    return this.value.collectAndPartialResolve(_scope);
}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
    return this.value.completeResolve(_scope);
}
@Override
public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
    if (this.function == null) {
        this.function = _container; // Associate the return statement with the function
    } else if (!this.function.equals(_container)) {
        Logger.error("Return statement is associated with a different function.");
        return false;
    }
    return this.value.collectAndPartialResolve(_scope);
}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
public boolean checkType() {
    // Verify that the function is associated
    if (this.function == null) {
        Logger.error("Return statement is not associated with a function.");
        return false;
    }

    // Check if the return type matches the function's declared return type
    if (!this.value.getType().equalsTo(this.function.getType())) {
        Logger.error("The return type does not match the declared return type of the function " + this.function.getName());
        return false;
    }

    return true;
}
	

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		// Le return ne déclare pas de mémoire locale supplémentaire
		return 0;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		// Génère le code pour évaluer l'expression retournée
		fragment.append(this.value.getCode(_factory));

		// Ajoute une instruction de retour TAM
		// _keep : taille de la valeur retournée (normalement 1 pour un type atomique)
		// _remove : taille de la mémoire allouée pour les variables locales de la fonction
		//fragment.add(_factory.createReturn(this.function.getType().length(), this.function.getBody().getAllocatedSize()));
		fragment.add(_factory.createReturn(this.function.getType().length(), 0));

		return fragment;
	}


}
