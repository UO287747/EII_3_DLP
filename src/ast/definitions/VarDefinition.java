package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;
import visitor.Visitor;

import java.util.Objects;

public class VarDefinition extends AbstractDefinition {


    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarDefinition that = (VarDefinition) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "VarDefinition{" +
                "line=" + line +
                ", column=" + column +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
