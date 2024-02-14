package ast.statements;

import ast.AbstractASTNode;
import ast.Statement;

public class FuncInvocation extends AbstractASTNode implements Statement {

    public FuncInvocation(int line, int column) {
        super(line, column);
    }
}
