package ast;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class ErrorHandler extends AbstractASTNode {

    private static ErrorHandler instance;
    private List<ErrorType> errors = new ArrayList<ErrorType>();

    private ErrorHandler() {
        super(0,0);
    }

    private ErrorHandler(int line, int column) {
        super(line, column);
    }

    public static ErrorHandler getInstance() {
        if (instance == null) {
            instance = new ErrorHandler();
        }
        return instance;
    }

    public boolean anyError() {

        return !errors.isEmpty();
    }

    public void showErrors(PrintStream err) {

    }

    public void addError(ErrorType error) {
        this.errors.add(error);
    }
}
