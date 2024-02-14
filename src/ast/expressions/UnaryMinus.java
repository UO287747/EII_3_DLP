package ast.expressions;

import ast.Expression;

public class UnaryMinus extends AbstractExpresion {

    private Expression expression;

    public UnaryMinus(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "UnaryMinus{" +
                "expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
