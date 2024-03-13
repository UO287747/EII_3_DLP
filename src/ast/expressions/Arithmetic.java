package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class Arithmetic extends AbstractExpression {

    private Expression left;
    private Expression right;

    private String OP;

    public Arithmetic(int line, int column, Expression left, Expression right, String OP) {
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
        return "Arithmetic{" +
                "OP='" + OP + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
