package ast.expressions;

import ast.Expression;

public class Arithmetic extends AbstractExpresion {

    private Expression left;
    private Expression right;

    private String operator;

    public Arithmetic(int line, int column, Expression left, Expression right, String operator) {
        super(line, column);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "Arithmetic{" +
                "operator='" + operator + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
