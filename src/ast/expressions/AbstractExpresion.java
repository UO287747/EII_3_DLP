package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;

public class AbstractExpresion extends AbstractASTNode implements Expression {

    public AbstractExpresion(int line, int column) {
        super(line, column);
    }
}
