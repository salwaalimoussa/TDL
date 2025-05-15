/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractAccess;
import fr.n7.stl.minic.ast.expression.AbstractIdentifier;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for an identifier access
 * expression (can be a variable,
 * a parameter, a constant, a function, ...).
 * Will be connected to an appropriate object after resolving the identifier to
 * know to which kind of element
 * it is associated (variable, parameter, constant, function, ...).
 * 
 * @author Marc Pantel
 *         TODO : Should also hold a function and not only a variable.
 */
public class IdentifierAccess extends AbstractIdentifier implements AccessibleExpression {

    protected AbstractAccess expression;

    /**
     * Creates a variable use expression Abstract Syntax Tree node.
     * 
     * @param _name Name of the used variable.
     */
    public IdentifierAccess(String _name) {
        super(_name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.name;
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
        // Vérifie si l'identifiant est connu dans la portée
        if (_scope.knows(this.name)) {
            // Récupère la déclaration associée à l'identifiant
            Declaration _declaration = _scope.get(this.name);

            // Si c'est une variable, crée un accès à la variable
            if (_declaration instanceof VariableDeclaration) {
                this.expression = new VariableAccess((VariableDeclaration) _declaration);

                // Si c'est une constante, crée un accès à la constante
            } else if (_declaration instanceof ConstantDeclaration) {
                this.expression = new ConstantAccess((ConstantDeclaration) _declaration);

                // Si c'est un paramètre, crée un accès à un paramètre
            } else if (_declaration instanceof ParameterDeclaration) {
                this.expression = new ParameterAccess((ParameterDeclaration) _declaration);

                // Si le type de déclaration n'est pas supporté, log une erreur
            } else {
                Logger.error("The declaration for " + this.name + " is of the wrong kind.");
                return false;
            }
        } else {
            // Si l'identifiant n'est pas trouvé, log une erreur
            Logger.error("The identifier " + this.name + " has not been found.");
            return false;
        }
        return true;
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
        // Si l'expression n'est pas encore résolue
        if (this.expression == null) {
            // Vérifie si l'identifiant est connu dans la portée
            if (_scope.knows(this.name)) {
                // Récupère la déclaration associée à l'identifiant
                Declaration _declaration = _scope.get(this.name);

                // Si c'est une constante, crée un accès à la constante
                if (_declaration instanceof ConstantDeclaration) {
                    this.expression = new ConstantAccess((ConstantDeclaration) _declaration);
                    return true;

                    // Si c'est une variable, crée un accès à la variable
                } else if (_declaration instanceof VariableDeclaration) {
                    this.expression = new VariableAccess((VariableDeclaration) _declaration);
                    return true;

                    // Si c'est un paramètre, crée un accès à un paramètre
                } else if (_declaration instanceof ParameterDeclaration) {
                    this.expression = new ParameterAccess((ParameterDeclaration) _declaration);
                    return true;

                    // Si le type de déclaration n'est pas supporté, log une erreur
                } else {
                    Logger.error("The declaration for " + this.name + " is of the wrong kind.");
                    return false;
                }
            } else {
                // Si l'identifiant n'est pas trouvé, log une erreur
                Logger.error("The identifier " + this.name + " has not been found.");
                return false;
            }
        } else {
            // Si l'expression est déjà résolue, retourne true
            return true;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.Expression#getType()
     */
    @Override
    public Type getType() {
        return this.expression.getType();
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
     */
    @Override
    public Fragment getCode(TAMFactory _factory) {
        return this.expression.getCode(_factory);
    }

}