package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class Integer extends AbstractASTNode implements Type {

    public Integer(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Integer{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
