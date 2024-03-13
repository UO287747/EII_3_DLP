package semantic;

import ast.Expression;
import ast.Program;
import ast.RecordField;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public class TypeCheckingVisitor implements Visitor<Void,Void> {

    @Override
    public Void visit(Program e, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordField e, Void param) {
        return null;
    }

    @Override
    public Void visit(FuncDefinition e, Void param) {
        return null;
    }

    @Override
    public Void visit(VarDefinition e, Void param) {
        return null;
    }

    @Override
    public Void visit(Arithmetic e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Cast e, Void param) {

        e.getType().accept(this, param);
        e.getExpression().accept(this, param);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral e, Void param) {

        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparison e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FuncInvocation e, Void param) {

        e.getVariable().accept(this, param);
        for (Expression expression: e.getExpressions()) {
            e.accept(this, param);
        }
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral e, Void param) {

        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Logic e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(RealLiteral e, Void param) {

        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(StructAccess e, Void param) {

        e.getExpression().accept(this, param);
        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(UnaryMinus e, Void param) {

        e.getExpression().accept(this, param);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot e, Void param) {

        e.getExpression().accept(this, param);
        e.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {

        e.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        if (e.getLeft().getLvalue())
            new ErrorType(e.getLine(), e.getColumn(), "Error type");
        return null;
    }

    @Override
    public Void visit(IfElse e, Void param) {

        e.getCondition().accept(this, param);
        for (Statement statement: e.getIfBody())
            statement.accept(this, param);
        for (Statement statement: e.getElseBody())
            statement.accept(this, param);
        return null;
    }

    @Override
    public Void visit(Input e, Void param) {
        return null;
    }

    @Override
    public Void visit(Print e, Void param) {

        e.accept(this, param);
        return null;
    }

    @Override
    public Void visit(Return e, Void param) {
        return null;
    }

    @Override
    public Void visit(While e, Void param) {
        return null;
    }

    @Override
    public Void visit(ArrayType e, Void param) {
        return null;
    }

    @Override
    public Void visit(CharType e, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleType e, Void param) {
        return null;
    }

    @Override
    public Void visit(ErrorType e, Void param) {
        return null;
    }

    @Override
    public Void visit(FunctionType e, Void param) {
        return null;
    }

    @Override
    public Void visit(IntType e, Void param) {
        return null;
    }

    @Override
    public Void visit(StructType e, Void param) {
        return null;
    }

    @Override
    public Void visit(VoidType e, Void param) {
        return null;
    }
}
