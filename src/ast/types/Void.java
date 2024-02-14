package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class Void extends AbstractASTNode implements Type {

    public Void(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Void{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
