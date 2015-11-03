package org.ñ.compiler.semantics

import org.ñ.compiler.parser.ast.BinaryExpr
import org.ñ.compiler.parser.ast.CardinalityCall
import org.ñ.compiler.parser.ast.CondExpr
import org.ñ.compiler.parser.ast.ConstDef
import org.ñ.compiler.parser.ast.DataType
import org.ñ.compiler.parser.ast.FuncCall
import org.ñ.compiler.parser.ast.FuncDef
import org.ñ.compiler.parser.ast.IdDecl
import org.ñ.compiler.parser.ast.IdLiteral
import org.ñ.compiler.parser.ast.MatrixAccess
import org.ñ.compiler.parser.ast.OperatorType
import org.ñ.compiler.parser.ast.Program
import org.ñ.compiler.parser.ast.UnaryExpr
import org.ñ.compiler.parser.ast.VectorAccess
import org.ñ.compiler.parser.ast.visitor.AbstractASTVisitor
import org.ñ.compiler.semantics.symboltable.SymbolTable

class SemanticAnalyzer extends AbstractASTVisitor {

    private SymbolTable currentScope
    List<SemanticError> errors = []

    @Override
    void visit(Program program) {
        currentScope = program.scope
        super.visit(program)
    }

    @Override
    void visit(ConstDef constDef) {
        super.visit(constDef)

        // check types
        if (constDef.identifier.dataType != constDef.value.dataType) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                        token: constDef.identifier.token,
                                        expecting: [constDef.identifier.dataType],
                                        received: [constDef.value.dataType])
        }
    }

    @Override
    void visit(FuncDef funcDef) {
        def tempScope = currentScope
        currentScope = funcDef.scope

        funcDef.body.each { expr ->
            expr.accept(this)

            // check types
            if (funcDef.identifier.dataType != expr.dataType) {
                errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                            token: funcDef.identifier.token,
                                            expecting: [funcDef.identifier.dataType],
                                            received: [expr.dataType])
            }
        }

        // pop scope
        currentScope = tempScope
    }

    @Override
    void visit(IdLiteral idLiteral) {
        IdDecl entry = currentScope.lookup(idLiteral.token.text)
        idLiteral.dataType = entry.dataType
    }

    @Override
    void visit(FuncCall funcCall) {
        IdDecl entry = currentScope.lookup(funcCall.identifier.token.text)

        // assign expr datatype
        funcCall.dataType = entry.dataType

        // check types
        funcCall.params.eachWithIndex { paramExpr, index ->
            paramExpr.accept(this)
            if (paramExpr.dataType != entry?.paramTypes[index]) {
                errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                            token: funcCall.identifier.token,
                                            expecting: [entry?.paramTypes[index]],
                                            received: [paramExpr.dataType])
            }
        }
    }

    @Override
    void visit(CardinalityCall cardinalityCall) {
        cardinalityCall.expr.accept(this)
        cardinalityCall.dataType = DataType.INTEGER

        // check types
        if (cardinalityCall.expr.dataType != DataType.VECTOR) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                        expecting: [DataType.VECTOR],
                                        received: [cardinalityCall.expr.dataType],
                                        token: cardinalityCall.token)
        } else if (cardinalityCall.expr.dataType != DataType.MATRIX) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                        expecting: [DataType.MATRIX],
                                        received: [cardinalityCall.expr.dataType],
                                        token: cardinalityCall.token)
        }
    }

    @Override
    void visit(VectorAccess vectorAccess) {
        super.visit(vectorAccess)

        // check types
        if (vectorAccess.identifier.dataType != DataType.VECTOR) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                        token: vectorAccess.identifier.token,
                                        expecting: [DataType.VECTOR],
                                        received: [vectorAccess.identifier.dataType])
        }

        if (vectorAccess.index.dataType != DataType.INTEGER) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                        token: vectorAccess.identifier.token,
                                        expecting: [DataType.INTEGER],
                                        received: [vectorAccess.index.dataType])
        }
    }

    @Override
    void visit(MatrixAccess matrixAccess) {
        super.visit(matrixAccess)

        // check types
        if (matrixAccess.identifier.dataType != DataType.MATRIX) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                    token: matrixAccess.identifier.token,
                    expecting: [DataType.VECTOR],
                    received: [matrixAccess.identifier.dataType])
        }

        if (matrixAccess.indexRow.dataType != DataType.INTEGER) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                    token: matrixAccess.identifier.token,
                    expecting: [DataType.INTEGER],
                    received: [matrixAccess.indexRow.dataType])
        }

        if (matrixAccess.indexCol.dataType != DataType.INTEGER) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                    token: matrixAccess.identifier.token,
                    expecting: [DataType.INTEGER],
                    received: [matrixAccess.indexCol.dataType])
        }
    }

    @Override
    void visit(CondExpr condExpr) {
        super.visit(condExpr)

        condExpr.dataType = condExpr.expr.dataType

        // check types
        if (condExpr.cond.dataType != DataType.BOOLEAN) {
            errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                        expecting: [DataType.BOOLEAN],
                                        received: [condExpr.cond.dataType],
                                        token: condExpr.token)
        }
    }

    @Override
    void visit(UnaryExpr unaryExpr) {
        super.visit(unaryExpr)

        unaryExpr.dataType = unaryExpr.operand.dataType

        // check types
        switch(unaryExpr.operatorType) {
            case OperatorType.NOT:
                if (unaryExpr.operand.dataType != DataType.BOOLEAN) {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.BOOLEAN],
                                                received: [unaryExpr.operand.dataType],
                                                token: unaryExpr.token)
                }
                break

            case OperatorType.NEG:
                if (unaryExpr.operand.dataType != DataType.INTEGER) {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.INTEGER],
                                                received: [unaryExpr.operand.dataType],
                                                token: unaryExpr.token)
                } else if (unaryExpr.operand.dataType != DataType.REAL) {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.REAL],
                                                received: [unaryExpr.operand.dataType],
                                                token: unaryExpr.token)
                }
                break

            case OperatorType.TRANSP:
                if (unaryExpr.operand.dataType != DataType.MATRIX) {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.MATRIX],
                                                received: [unaryExpr.operand.dataType],
                                                token: unaryExpr.token)
                }
                break
        }
    }

    @Override
    void visit(BinaryExpr binaryExpr) {
        super.visit(binaryExpr)

        switch(binaryExpr.operatorType) {
            case OperatorType.POW:
                if (binaryExpr.rightOperand.dataType != DataType.INTEGER) {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.INTEGER],
                                                received: [binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                } else if (binaryExpr.leftOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.INTEGER
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.REAL, DataType.INTEGER],
                                                received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                }
                break
            case OperatorType.DIV:
                if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.REAL
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                            expecting: [DataType.REAL, DataType.INTEGER],
                            received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                            token: binaryExpr.token)
                }
                break
            case OperatorType.QUOT:
            case OperatorType.MOD:
                if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.INTEGER
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.INTEGER],
                                                received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                }
                break

            case OperatorType.MULT:
                if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.INTEGER
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.VECTOR) {
                    binaryExpr.dataType = DataType.VECTOR
                } else if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.VECTOR) {
                    binaryExpr.dataType = DataType.VECTOR
                } else if (binaryExpr.leftOperand.dataType == DataType.VECTOR && binaryExpr.rightOperand.dataType == DataType.MATRIX) {
                    binaryExpr.dataType = DataType.MATRIX
                } else if (binaryExpr.leftOperand.dataType == DataType.MATRIX && binaryExpr.rightOperand.dataType == DataType.MATRIX) {
                    binaryExpr.dataType = DataType.MATRIX
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.REAL, DataType.INTEGER, DataType.VECTOR, DataType.MATRIX],
                                                received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                }
                break

            case OperatorType.ADD:
            case OperatorType.SUB:
                if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.REAL
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.INTEGER
                } else if (binaryExpr.leftOperand.dataType == DataType.VECTOR && binaryExpr.rightOperand.dataType == DataType.VECTOR) {
                    binaryExpr.dataType = DataType.VECTOR
                } else if (binaryExpr.leftOperand.dataType == DataType.MATRIX && binaryExpr.rightOperand.dataType == DataType.MATRIX) {
                    binaryExpr.dataType = DataType.MATRIX
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                            expecting: [DataType.REAL, DataType.INTEGER, DataType.VECTOR, DataType.MATRIX],
                            received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                            token: binaryExpr.token)
                }
                break
            case OperatorType.DOT:
                if (binaryExpr.leftOperand.dataType == DataType.VECTOR && binaryExpr.rightOperand.dataType == DataType.VECTOR) {
                    binaryExpr.dataType = DataType.REAL
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.VECTOR],
                                                received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                }
                break

            case OperatorType.EQ:
            case OperatorType.NEQ:
            case OperatorType.GT:
            case OperatorType.GE:
            case OperatorType.LT:
            case OperatorType.LE:
                if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.BOOLEAN
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.REAL) {
                    binaryExpr.dataType = DataType.BOOLEAN
                } else if (binaryExpr.leftOperand.dataType == DataType.REAL && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.BOOLEAN
                } else if (binaryExpr.leftOperand.dataType == DataType.INTEGER && binaryExpr.rightOperand.dataType == DataType.INTEGER) {
                    binaryExpr.dataType = DataType.BOOLEAN
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.REAL, DataType.INTEGER],
                                                received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                }
                break

            case OperatorType.AND:
            case OperatorType.OR:
                if (binaryExpr.leftOperand.dataType == DataType.BOOLEAN && binaryExpr.rightOperand.dataType == DataType.BOOLEAN) {
                    binaryExpr.dataType = DataType.BOOLEAN
                } else {
                    errors << new SemanticError(errorType: ErrorType.TYPE_MISMATCH,
                                                expecting: [DataType.BOOLEAN],
                                                received: [binaryExpr.leftOperand.dataType, binaryExpr.rightOperand.dataType],
                                                token: binaryExpr.token)
                }
        }
    }
}
