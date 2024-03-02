package ast.expressions;

import ast.Expression;

public class Comparison extends AbstractExpresion {

    private Expression left;
    private Expression right;

    private String OP;

    public Comparison(int line, int column, Expression left, Expression right, String OP) {
        super(line, column);
        this.left = left;
        this.right = right;
        this.OP = OP;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOP() {
        return OP;
    }

    @Override
    public String toString() {
        return "Comparison{" +
                "OP='" + OP + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
