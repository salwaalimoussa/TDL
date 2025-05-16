/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.Conditional;
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
	// int add(int x, int y) {
	// return x + y;}
	/*
	 * The function add is registered in the global scope.
	 * The parameters x and y are registered in the local scope of the function.
	 * The body of the function (return x + y;) is resolved using the local scope.
	 */

	 // filepath: /Users/elayboudiimane/Documents/semantique/TDL/src/fr/n7/stl/minic/ast/instruction/declaration/FunctionDeclaration.java
	 @Override
	 public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		 // Register the function in the global scope
		 if (_scope.accepts(this)) {
			 _scope.register(this);
		 } else {
			 Logger.error("Function " + this.name + " is already declared in this scope.");
			 return false;
		 }
	 
		 // Create a local scope for the function's parameters and body
		 HierarchicalScope<Declaration> localScope = new SymbolTable(_scope);
		     localScope.register(this); // ✅ POURQUOI ? Pour permettre l'appel récursif

		 // Register parameters in the local scope
		 boolean parametersResolved = true;
		 for (ParameterDeclaration parameter : this.parameters) {
			 if (localScope.accepts(parameter)) {
				 localScope.register(parameter);
			 } else {
				 Logger.error("Parameter " + parameter.getName() + " is already declared in this scope.");
				 parametersResolved = false;
			 }
		 }
	 
		 // Pass the FunctionDeclaration instance to the body
		 boolean bodyResolved = this.body.collectAndPartialResolve(localScope, this);
	 
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

		// Crée une portée locale et ajoute les paramètres
		HierarchicalScope<Declaration> localScope = new SymbolTable(_scope);
		for (ParameterDeclaration parameter : this.parameters) {
			localScope.register(parameter);
		}

		// Fully resolve the body of the function using la portée locale
		boolean bodyResolved = this.body.completeResolve(localScope);

		return parametersResolved && bodyResolved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.instruction.Instruction#checkType()
	 */
	@Override
public boolean checkType() {
    HierarchicalScope<Declaration> functionScope = new SymbolTable();
    
    // Register parameters
    for (ParameterDeclaration param : parameters) {
        functionScope.register(param);
    }
    
    // Set function context
    if (!this.body.collectAndPartialResolve(functionScope, this)) {
        return false;
    }
    
    // Check for returns recursively
    if (!hasValidReturn(this.body)) {
        Logger.error("Function " + this.name + " missing return");
        return false;
    }
    
    return this.body.checkType();
}

private boolean hasValidReturn(Block block) {
    for (Instruction instruction : block.getInstructions()) {
        if (instruction instanceof Return) {
            Return returnInst = (Return) instruction;
            return returnInst.getValue().getType().equalsTo(this.type);
        }
        if (instruction instanceof Conditional) {
            Conditional cond = (Conditional) instruction;
            boolean thenReturns = hasValidReturn(cond.getThenBranch());
            boolean elseReturns = cond.getElseBranch() == null || 
                                hasValidReturn(cond.getElseBranch());
            if (thenReturns && elseReturns) {
                return true;
            }
        }
    }
    return false;
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

    // Ajout du corps (le conditional qui contient then/else)
    fragment.append(this.body.getCode(_factory));

    // Ajout du return après le corps (avec taille de la valeur retournée et nombre paramètres)
    //fragment.add(_factory.createReturn(this.type.length(), this.parameters.size()));
	if (!bodyHasReturn(this.body)) {
        fragment.add(_factory.createReturn(this.type.length(), this.parameters.size()));
    }
    // Ajout label fonction (pour appel)
    fragment.addPrefix(this.name);

    return fragment;
}


	private boolean bodyHasReturn(Block block) {
		for (Instruction instr : block.getInstructions()) {
			if (instr instanceof Return) {          // return explicite
				return true;
			}
			if (instr instanceof Conditional ) {// if ... else ...
				Conditional cond = (Conditional) instr;
				if (bodyHasReturn(cond.getThenBranch())
				 && cond.getElseBranch() != null
				 && bodyHasReturn(cond.getElseBranch())) {
					return true;                    // les deux branches retournent
				}
			}
		}
		return false;
	}
	

	/*
	 * public Block getBody() {
	 * return this.body;
	 * }
	 */

}
