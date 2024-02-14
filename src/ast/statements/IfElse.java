package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;

import java.util.List;

public class IfElse extends AbstractASTNode implements Statement {

    private List<Statement> ifBody;
    private List<Statement> elseBody;

    private Expression condition;

    public IfElse(int line, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        this.ifBody = ifBody;
        this.elseBody = elseBody;

        this.condition = condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public String toString() {
        return "IfElse{" +
                "ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                ", expression=" + condition +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
