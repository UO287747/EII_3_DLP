package ast.expressions;

import ast.Expression;

public class ArrayAccess extends AbstractExpresion {

    private Expression left;
    private Expression right;

    public ArrayAccess(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "ArrayAccess{" +
                "left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
