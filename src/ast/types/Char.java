package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class Char extends AbstractASTNode implements Type {

    public Char(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Char{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
