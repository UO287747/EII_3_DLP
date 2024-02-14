package ast.expressions;

import ast.Expression;

public class UnaryNot extends AbstractExpresion {

    private Expression expression;

    public UnaryNot(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "UnaryNot{" +
                "expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
