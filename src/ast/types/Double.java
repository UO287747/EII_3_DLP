package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class Double extends AbstractASTNode implements Type {

    public Double(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Double{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
