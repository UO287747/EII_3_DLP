package ast.expressions;

import ast.Expression;

public class Logic extends AbstractExpresion {

    private String operator;

    private Expression left;
    private Expression right;

    public Logic(int line, int column, Expression left, Expression right, String operator) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "operator='" + operator + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
