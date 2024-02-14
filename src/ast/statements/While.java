package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class While extends AbstractASTNode implements Statement {

    private Expression condition;
    private List<Statement> statements;

    public While(int line, int column, Expression condition, List<Statement> statements) {
        super(line, column);
        this.condition = condition;
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        return "While{" +
                "statements=" + statements +
                ", expression=" + condition +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
