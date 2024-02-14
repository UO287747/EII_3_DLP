package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.definitions.VarDefinition;

import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    private Type returnType;
    private List<VarDefinition> varDefinitions;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> varDefinitions) {
        super(line, column);
        this.returnType = returnType;
        this.varDefinitions = varDefinitions;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "line=" + line +
                ", column=" + column +
                ", returnType=" + returnType +
                ", varDefinitions=" + varDefinitions +
                '}';
    }
}
