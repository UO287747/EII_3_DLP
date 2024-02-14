package ast.expressions;

import ast.Expression;

import java.util.List;

public class FuncCall extends AbstractExpresion {

    private List<Expression> expressions;
    private Variable variable;

    public FuncCall(int line, int column, List<Expression> expressions, Variable variable) {
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
