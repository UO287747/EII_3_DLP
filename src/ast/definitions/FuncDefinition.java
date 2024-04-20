package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Statement;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public class FuncDefinition extends AbstractDefinition  {

    private List<Statement> statements;
    private List<VarDefinition> varDefinitions;
    private int localBytes;

    public FuncDefinition(int line, int column, Type type, String name, List<VarDefinition> variableDefinitions, List<Statement> statements) {
        super(line, column);

        this.type = type;
        this.name = name;

        this.varDefinitions = variableDefinitions;
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    public int getLocalBytes() {
        return localBytes;
    }

    public void setLocalBytes(int localBytes) {
        this.localBytes = localBytes;
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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
