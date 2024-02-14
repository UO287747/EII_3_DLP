package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Statement;
import ast.Type;

import java.util.List;

public class FuncDefinition extends AbstractASTNode implements Definition {

    private Type type;
    private String name;

    private List<Statement> statements;
    private List<VarDefinition> varDefinitions;

    public FuncDefinition(int line, int column, Type type, String name, List<VarDefinition> variableDefinitions, List<Statement> statements) {
        super(line, column);

        this.type = type;
        this.name = name;

        this.varDefinitions = variableDefinitions;
        this.statements = statements;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    @Override
    public String toString() {
        return "FuncDefinition{" +
                "line=" + line +
                ", column=" + column +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", statements=" + statements +
                ", varDefinitions=" + varDefinitions +
                '}';
    }
}
