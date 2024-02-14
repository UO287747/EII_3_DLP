package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Assignment extends AbstractASTNode implements Statement {

    private Expression left;
    private Expression right;

    public Assignment(int line, int column, Expression left, Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "left=" + left +
                ", right=" + right +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
