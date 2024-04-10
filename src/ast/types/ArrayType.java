package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class ArrayType extends AbstractType {

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type type, ASTNode ast) {

        if (type.equals(IntType.getInstance())) { return this.getType(); }
        return super.squareBrackets(type, ast);
    }

    @Override
    public int numberOfBytes() {
        return size * OF.numberOfBytes();
    }
}
