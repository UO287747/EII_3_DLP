package ast.expressions;

import ast.Expression;
import ast.Statement;

import java.util.List;

public class FuncInvocation extends AbstractExpresion implements Statement {

    private List<Expression> expressions;
    private Variable variable;

    public FuncInvocation(int line, int column, List<Expression> expressions, Variable variable) {
        super(line, column);
        this.expressions = expressions;
        this.variable = variable;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        return "FuncCall{" +
                "expression=" + expressions +
                ", variable=" + variable +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
