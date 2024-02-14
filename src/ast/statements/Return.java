package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Return extends AbstractASTNode implements Statement {

    private Expression expression;

    public Return(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Return{" +
                "expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
