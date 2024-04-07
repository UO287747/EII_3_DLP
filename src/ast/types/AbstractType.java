package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type  {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type asBuiltInType(ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo primitivo.");
    }

    @Override
    public Type asLogical(ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo logico.");
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(),
                "Error: no se puede realizar la operacion para los tipos " + type + " - " + this);
    }

    @Override
    public Type arithmetic(ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo aritmetico.");
    }

    @Override
    public Type logic(Type type, ASTNode ast) {

        if ( type instanceof ErrorType ) { return type; }
        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo logico.");
    }

    @Override
    public Type logic(ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo logico.");
    }

    @Override
    public Type promotesTo(Type type, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(),
                "Error: un " + this + " no puede promocionar a " + type + ".");
    }

    @Override
    public Type canBeCastTo(Type type, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(),
                "Error: no se puede hacer cast de " + this + " a " + type + ".");
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(),
                "Error: no se pueden comparar los tipos " + this + " - " + type + ".");
    }

    @Override
    public Type squareBrackets(Type type, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo Array.");
    }

    @Override
    public Type dot(String id, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: se esperaba un tipo Struct.");
    }

    @Override
    public  Type parenthesis(List<Type> list, ASTNode ast) {

        return new ErrorType(ast.getLine(), ast.getColumn(), "Error: parámetros incorrectos.");
    }

    @Override
    public boolean isBuiltInType(ASTNode ast){
        return false;
    }
}
