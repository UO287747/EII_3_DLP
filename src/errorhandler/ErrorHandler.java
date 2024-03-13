package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler instance;
    private List<ErrorType> errors;

    private ErrorHandler() {
        errors = new ArrayList<ErrorType>();
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

        for (ErrorType et: errors) {
            err.println(et);
        }
    }

    public void addError(ErrorType error) {
        errors.add(error);
    }
}
