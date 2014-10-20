package org.ñ.compiler.parser.ast

import groovy.transform.Canonical
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

@Canonical
abstract class ASTNode {
    abstract void accept(ASTVisitor visitor);
}
