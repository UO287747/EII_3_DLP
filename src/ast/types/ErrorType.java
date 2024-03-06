package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import ast.ErrorHandler;

public class ErrorType extends AbstractASTNode implements Type {

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
}
