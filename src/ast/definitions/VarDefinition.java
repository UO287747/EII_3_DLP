package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;

import java.util.Objects;

public class VarDefinition extends AbstractASTNode implements Definition {

    private Type type;
    private String name;

    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String getName() {
        return null;
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
}
