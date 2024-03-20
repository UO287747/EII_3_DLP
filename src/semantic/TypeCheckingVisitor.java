package semantic;

import ast.Expression;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Void,Void> {

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
            expression.accept(this, param);
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
        if (!e.getLeft().getLvalue())
            new ErrorType(e.getLine(), e.getColumn(), "Error type LValue.");
        return null;
    }

    @Override
    public Void visit(Input e, Void param) {

        e.getExpression().accept(this, param);
        if (!e.getExpression().getLvalue())
            new ErrorType(e.getLine(), e.getColumn(), "Error type LValue.");
        return null;
    }
}
