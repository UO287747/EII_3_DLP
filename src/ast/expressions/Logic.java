package ast.expressions;

import ast.Expression;

public class Logic extends AbstractExpresion {

    private String OP;

    private Expression left;
    private Expression right;

    public Logic(int line, int column, Expression left, Expression right, String OP) {
        super(line, column);
        this.OP = OP;
        this.left = left;
        this.right = right;
    }

    public String getOP() {
        return OP;
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
                "OP='" + OP + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
