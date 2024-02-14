package ast.types;

import ast.AbstractASTNode;
import ast.Type;

public class ArrayType extends AbstractASTNode implements Type {

    private int size;
    private Type OF;

    public ArrayType(int line, int column, int size, Type OF) {
        super(line, column);
        this.size = size;
        this.OF = OF;
    }

    public int getSize() {
        return size;
    }

    public Type getType() {
        return OF;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "line=" + line +
                ", column=" + column +
                ", size=" + size +
                ", OF=" + OF +
                '}';
    }
}
