package org.ñ.compiler.semantics

import org.ñ.compiler.parser.ast.*
import org.ñ.compiler.parser.ast.visitor.AbstractASTVisitor
import org.ñ.compiler.semantics.symboltable.SymbolTable

class SymbolTableBuilder extends AbstractASTVisitor {

    private SymbolTable currentScope = new SymbolTable() // global scope
    List<SemanticError> errors = []

    @Override
    void visit(Program program) {
        program.scope = currentScope
        super.visit(program)
    }

    @Override
    void visit(FuncDef funcDef) {
        funcDef.identifier.accept(this)

        // push scope
        SymbolTable newScope = new SymbolTable()
        newScope.parent = currentScope
        currentScope = newScope

        funcDef.params.each { it.accept(this) }
        funcDef.body.each { expr ->
            expr.accept(this)
        }

        funcDef.scope = currentScope

        // pop scope
        currentScope = currentScope.parent
    }

    @Override
    void visit(IdDecl idDecl) {
        if (currentScope.lookup(idDecl.token.text)) {
            errors << new SemanticError(errorType: ErrorType.ALREADY_DEFINED_IDENTIFIER,
                    token: idDecl.token)
        } else {
            currentScope.set(idDecl.token.text, idDecl)
        }
    }
}
