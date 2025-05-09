/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.Return;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract Syntax Tree node for a function declaration.
 * 
 * @author Marc Pantel
 */
public class FunctionDeclaration implements Instruction, Declaration {

	/**
	 * Name of the function
	 */
	protected String name;

	/**
	 * AST node for the returned type of the function
	 */
	protected Type type;

	/**
	 * List of AST nodes for the formal parameters of the function
	 */
	protected List<ParameterDeclaration> parameters;

	/**
	 * @return the parameters
	 */
	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	/**
	 * AST node for the body of the function
	 */
	protected Block body;

	/**
	 * Builds an AST node for a function declaration
	 * 
	 * @param _name       : Name of the function
	 * @param _type       : AST node for the returned type of the function
	 * @param _parameters : List of AST nodes for the formal parameters of the
	 *                    function
	 * @param _body       : AST node for the body of the function
	 */
	public FunctionDeclaration(String _name, Type _type, List<ParameterDeclaration> _parameters, Block _body) {
		this.name = _name;
		this.type = _type;
		this.parameters = _parameters;
		this.body = _body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = this.type + " " + this.name + "( ";
		Iterator<ParameterDeclaration> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += " ," + _iter.next();
			}
		}
		return _result + " )" + this.body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Declaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	// cette methode enregistre d'abord le nom de la fonction dans le scope
	// puis enregistre les parametres dans le scope local
	// puis appelle la methode collect de la classe Block
	// pour enregistrer les declarations locales
	// et les instructions
	// de la fonction
	// elle renvoie true si tout s'est bien passé
	// sinon elle renvoie false
	//int add(int x, int y) {
	//	return x + y;}
	/*The function add is registered in the global scope.
The parameters x and y are registered in the local scope of the function.
The body of the function (return x + y;) is resolved using the local scope.
 */


 @Override
 public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
	 // Enregistre la fonction dans la portée globale
	 if (_scope.accepts(this)) {
		 _scope.register(this);
	 } else {
		 Logger.error("Function " + this.name + " is already declared in this scope.");
		 return false;
	 }
 
	 // Crée une portée locale pour les paramètres et le corps de la fonction
	 HierarchicalScope<Declaration> localScope = new SymbolTable(_scope);
 
	 // Enregistre les paramètres dans la portée locale
	 boolean parametersResolved = true;
	 for (ParameterDeclaration parameter : this.parameters) {
		 if (localScope.accepts(parameter)) {
			 localScope.register(parameter); // Enregistre le paramètre
		 } else {
			 Logger.error("Parameter " + parameter.getName() + " is already declared in this scope.");
			 parametersResolved = false;
		 }
	 }
 
	 // Collecte et résout partiellement le corps de la fonction
	 boolean bodyResolved = this.body.collectAndPartialResolve(localScope);
 
	 return parametersResolved && bodyResolved;
 }
@Override
public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _function) {
	// Delegate to the existing collectAndPartialResolve method
	return this.collectAndPartialResolve(_scope);
}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
    // Fully resolve the parameters
    boolean parametersResolved = true;
    for (ParameterDeclaration parameter : this.parameters) {
        if (!parameter.getType().completeResolve(_scope)) {
            Logger.error("The type of parameter " + parameter.getName() + " could not be resolved.");
            parametersResolved = false;
        }
    }

    // Fully resolve the body of the function using a local scope
    boolean bodyResolved = this.body.completeResolve(new SymbolTable(_scope));

    return parametersResolved && bodyResolved;
}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.instruction.Instruction#checkType()
	 */
	@Override
public boolean checkType() {
    // Vérifie que le corps de la fonction est bien typé
    boolean bodyTypeCorrect = this.body.checkType();

    // Vérifie que le type de retour est respecté
    boolean returnTypeCorrect = false;

    // Parcourt les instructions du corps de la fonction
    for (Instruction instruction : this.body.getInstructions()) { 
        if (instruction instanceof Return) { 
            Return returnInstruction = (Return) instruction;

            // Vérifie si le type de la valeur retournée correspond au type déclaré
            if (returnInstruction.getValue().getType().equalsTo(this.type)) {
                returnTypeCorrect = true;
            } else {
                Logger.error("The return type of the function " + this.name + " does not match the expected type: " + this.type);
                return false;
            }
        }
    }

    // Vérifie qu'il existe au moins une instruction de retour valide
    if (!returnTypeCorrect) {
        Logger.error("The function " + this.name + " does not have a valid return statement.");
        return false;
    }

    // Retourne true si tout est correct
    return bodyTypeCorrect && returnTypeCorrect;
}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#allocateMemory(fr.n7.stl.tam.ast.
	 * Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		// On crée un registre de base pour les variables locales de la fonction
		int currentOffset = 0;

		// On alloue la mémoire pour chaque paramètre de la fonction
		for (ParameterDeclaration parameter : this.parameters) {
			// On suppose que les paramètres sont posés en mémoire consécutivement
			// Pas besoin d’appeler une méthode : on simule le comportement ici
			currentOffset += parameter.getType().length();
		}

		// On alloue ensuite la mémoire pour le corps de la fonction (variables locales)
		this.body.allocateMemory(Register.LB, currentOffset);

		// La fonction n’alloue rien dans le registre global à son niveau d’appel,
		// donc on retourne simplement l’offset inchangé
		return _offset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.instruction.Instruction#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		// Étiquette d’entrée de fonction (label)
		fragment.addPrefix(this.name);

		// Génère le code du corps de la fonction
		Fragment bodyCode = this.body.getCode(_factory);

		// Ajoute le code du corps à l’ensemble
		fragment.append(bodyCode);

		// Ajoute une instruction de retour implicite (utile si aucun return explicite n’est là)
		// → facultatif selon les règles de ton langage
		//fragment.add(_factory.createReturn(0, this.body.getAllocatedSize()));
		fragment.add(_factory.createReturn(0, 0));

		return fragment;
	}

	/*public Block getBody() {
		return this.body;
	}
	*/

}
