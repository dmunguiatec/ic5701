package org.ñ.compiler.semantics.symboltable

import org.ñ.compiler.parser.ast.IdDecl

class SymbolTable {
    private Map<String, IdDecl> table = [:]
    SymbolTable parent = null

    IdDecl lookup(String identifier) {
        IdDecl entry = table[identifier]
        if (entry) {
            return entry
        } else if (parent) {
            return parent.lookup(identifier)
        }

        return null
    }

    void set(String identifier, IdDecl entry) {
        table[identifier] = entry
    }
}
