package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;
import errorhandler.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "message='" + message + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type asBuiltInType(ASTNode ast) { return this; }

    @Override
    public Type asLogical(ASTNode ast) { return this; }

    @Override
    public Type arithmetic(Type type, ASTNode ast) { return this; }

    @Override
    public Type arithmetic(ASTNode ast) { return this; }

    @Override
    public Type logic(Type type, ASTNode ast) { return this; }

    @Override
    public Type logic(ASTNode ast) { return this; }

    @Override
    public Type promotesTo(Type type, ASTNode ast) { return this; }

    @Override
    public Type canBeCastTo(Type type, ASTNode ast) { return this; }

    @Override
    public Type comparison(Type type, ASTNode ast) { return this; }

    @Override
    public Type squareBrackets(Type type, ASTNode ast) { return this; }

    @Override
    public Type dot(String id, ASTNode ast) { return this; }

    @Override
    public Type parenthesis(List<Type> list, ASTNode ast) { return this; }
}
