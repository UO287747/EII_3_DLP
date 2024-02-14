package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

public class Input extends AbstractASTNode implements Statement {

    private Expression expression;

    public Input(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Input{" +
                "expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
