package ast.expressions;

import ast.Definition;

public class Variable extends AbstractExpresion {

    private String name;
    private Definition definition;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
