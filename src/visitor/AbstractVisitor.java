package visitor;

import ast.*;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstractVisitor<TP,TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Program e, TP param) {

        for (Definition def: e.getDefinitions())
            def.accept(this, param);
        return null;
    }

    @Override
    public TR visit(RecordField e, TP param) {

        e.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FuncDefinition e, TP param) {

        e.getType().accept(this, param);
        for (VarDefinition varDef: e.getVarDefinitions())
            varDef.accept(this, param);
        for (Statement statement: e.getStatements())
            statement.accept(this, param);
        return null;
    }

    @Override
    public TR visit(VarDefinition e, TP param) {

        e.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Arithmetic e, TP param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayAccess e, TP param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast e, TP param) {

        e.getType().accept(this, param);
        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharLiteral e, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison e, TP param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FuncInvocation e, TP param) {

        e.getVariable().accept(this, param);
        for (Expression expression: e.getExpressions())
            expression.accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntLiteral e, TP param) {
        return null;
    }

    @Override
    public TR visit(Logic e, TP param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RealLiteral e, TP param) {
        return null;
    }

    @Override
    public TR visit(StructAccess e, TP param) {

        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus e, TP param) {

        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryNot e, TP param) {

        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable e, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment e, TP param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IfElse e, TP param) {

        e.getCondition().accept(this, param);
        for (Statement statement: e.getIfBody())
            statement.accept(this, param);
        for (Statement statement: e.getElseBody())
            statement.accept(this, param);
        return null;
    }

    @Override
    public TR visit(Input e, TP param) {

        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Print e, TP param) {

        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Return e, TP param) {

        e.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While e, TP param) {

        e.getCondition().accept(this, param);
        for (Statement statement: e.getStatements())
            statement.accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayType e, TP param) {

        e.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharType e, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType e, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType e, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType e, TP param) {

        e.getReturnType().accept(this, param);
        for (VarDefinition def: e.getParams())
            def.accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntType e, TP param) {
        return null;
    }

    @Override
    public TR visit(StructType e, TP param) {

        for (RecordField recordField: e.getRecordFields())
            recordField.accept(this, param);
        return null;
    }

    @Override
    public TR visit(VoidType e, TP param) {
        return null;
    }
}
