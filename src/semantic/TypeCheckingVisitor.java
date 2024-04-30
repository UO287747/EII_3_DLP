package semantic;

import ast.Expression;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

import java.util.stream.Collectors;

public class TypeCheckingVisitor extends AbstractVisitor<Void,Void> {

    @Override
    public Void visit(Arithmetic e, Void param) {

        e.setLvalue(false);
        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setType(e.getLeft().getType().arithmetic(e.getRight().getType(), e));
        return null;
    }

    @Override
    public Void visit(ArrayAccess e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(true);
        e.setType(e.getLeft().getType().squareBrackets(e.getRight().getType(), e));
        return null;
    }

    @Override
    public Void visit(Cast e, Void param) {

        e.getType().accept(this, param);
        e.getExpression().accept(this, param);
        e.setLvalue(false);
        e.setType(e.getExpression().getType().canBeCastTo(e.getType(), e));
        return null;
    }

    @Override
    public Void visit(CharLiteral e, Void param) {

        e.setLvalue(false);
        e.setType(CharType.getInstance());
        return null;
    }

    @Override
    public Void visit(Comparison e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(false);
        e.setType(e.getLeft().getType().comparison(e.getRight().getType(), e));
        return null;
    }

    @Override
    public Void visit(FuncInvocation e, Void param) {

        e.getVariable().accept(this, param);
        for (Expression expression : e.getExpressions()) {
            expression.accept(this, param);
        }
        e.setLvalue(false);
        e.setType(e.getVariable().getDefinition().getType().parenthesis(
                e.getExpressions().stream().map(Expression::getType).collect(Collectors.toList()), e));
        return null;
    }

    @Override
    public Void visit(IntLiteral e, Void param) {

        e.setLvalue(false);
        e.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(Logic e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        e.setLvalue(false);
        e.setType(e.getLeft().getType().logic(e.getRight().getType(), e));
        return null;
    }

    @Override
    public Void visit(RealLiteral e, Void param) {

        e.setLvalue(false);
        e.setType(DoubleType.getInstance());
        return null;
    }

    @Override
    public Void visit(StructAccess e, Void param) {

        e.getExpression().accept(this, param);
        e.setLvalue(true);
        e.setType(e.getExpression().getType().dot(e.getName(), e));
        return null;
    }

    @Override
    public Void visit(UnaryMinus e, Void param) {

        e.getExpression().accept(this, param);
        e.setLvalue(false);
        e.setType(e.getExpression().getType().arithmetic(e));
        return null;
    }

    @Override
    public Void visit(UnaryNot e, Void param) {

        e.getExpression().accept(this, param);
        e.setLvalue(false);
        e.setType(e.getExpression().getType().logic(e));
        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {

        e.setLvalue(true);
        e.setType(e.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(Assignment e, Void param) {

        e.getLeft().accept(this, param);
        e.getRight().accept(this, param);
        if (!e.getLeft().getLvalue())
            new ErrorType(e.getLine(), e.getColumn(), "Error type LValue.");
        e.getRight().getType().promotesTo(e.getLeft().getType(), e);
        return null;
    }

    @Override
    public Void visit(IfElse e, Void param) {

        e.getCondition().accept(this, param);
        for (Statement statement: e.getIfBody())
            statement.accept(this, param);
        for (Statement statement: e.getElseBody())
            statement.accept(this, param);
        e.getCondition().setType(e.getCondition().getType().asLogical(e.getCondition().getType()));
        return null;
    }

    @Override
    public Void visit(Input e, Void param) {

        e.getExpression().accept(this, param);
        if (!e.getExpression().getLvalue())
            new ErrorType(e.getLine(), e.getColumn(), "Error type LValue.");
        e.getExpression().setType(e.getExpression().getType().asBuiltInType(e.getExpression().getType()));
        return null;
    }

    @Override
    public Void visit(Print e, Void param) {

        e.getExpression().accept(this, param);
        e.getExpression().setType(e.getExpression().getType().asBuiltInType(e.getExpression().getType()));
        return null;
    }

    @Override
    public Void visit(While e, Void param) {

        e.getCondition().accept(this, param);
        for (Statement statement: e.getStatements())
            statement.accept(this, param);
        e.getCondition().setType(e.getCondition().getType().asLogical(e.getCondition().getType()));
        return null;
    }
}