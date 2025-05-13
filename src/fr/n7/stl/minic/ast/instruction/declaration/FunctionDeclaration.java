/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.Block;
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
    // Create new scope for function
    HierarchicalScope<Declaration> functionScope = new SymbolTable();
    
    // Add parameters to scope
    for (ParameterDeclaration param : parameters) {
        functionScope.register(param);
    }
    
    // Step 1: Set function context with proper scope
    boolean contextSet = this.body.collectAndPartialResolve(functionScope, this);
    if (!contextSet) {
        return false;
    }
    
    // Step 2: Check return types
    boolean returnTypeCorrect = false;
    for (Instruction instruction : this.body.getInstructions()) {
        if (instruction instanceof Return) {
            Return returnInstruction = (Return) instruction;
            if (returnInstruction.getValue().getType().equalsTo(this.type)) {
                returnTypeCorrect = true;
            } else {
                Logger.error("Function " + this.name + " return type mismatch");
                return false;
            }
        }
    }
    
    if (!returnTypeCorrect) {
        Logger.error("Function " + this.name + " missing return");
        return false;
    }
    
    // Step 3: Check body types with proper scope
    return this.body.checkType();
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
    
    // 1. Add PUSH to make fragment non-empty before label
    fragment.add(_factory.createPush(0));
    
    // 2. Now we can add the label safely
    fragment.addPrefix(this.name);
    
    // 3. Remove temporary PUSH
    fragment.add(_factory.createPop(0, 0));
    // 4. Generate and add body code
    Fragment bodyCode = this.body.getCode(_factory);
    fragment.append(bodyCode);
    
    // 5. Add return sequence
    fragment.add(_factory.createReturn(0, 0));
    
    return fragment;
}

	/*public Block getBody() {
		return this.body;
	}
	*/

}
