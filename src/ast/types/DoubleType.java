package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType {

    private static DoubleType instance;

    public DoubleType(int line, int column) {
        super(line, column);
    }

    public static DoubleType getInstance() {
        if (instance == null) {
            instance = new DoubleType(0,0);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Double{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
