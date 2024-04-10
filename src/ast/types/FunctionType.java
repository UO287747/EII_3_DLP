package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;
import ast.definitions.VarDefinition;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public  Type parenthesis(List<Type> list, ASTNode ast) {

        if (list.size() != params.size()) { return super.parenthesis(list, ast); }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).promotesTo(params.get(i).getType(), ast) instanceof ErrorType) {
                return super.parenthesis(list, ast);
            }
        }
        return returnType;
    }

}
