package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class Logic extends AbstractExpression {

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
