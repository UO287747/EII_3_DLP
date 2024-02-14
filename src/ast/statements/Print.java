package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Print extends AbstractASTNode implements Statement {

    private Expression expression;

    public Print(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Print{" +
                "expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
