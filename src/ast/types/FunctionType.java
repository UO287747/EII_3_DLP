package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.definitions.VarDefinition;

import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    private Type returnType;
    private List<VarDefinition> params;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> params) {
        super(line, column);
        this.returnType = returnType;
        this.params = params;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VarDefinition> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "line=" + line +
                ", column=" + column +
                ", returnType=" + returnType +
                ", params=" + params +
                '}';
    }
}
