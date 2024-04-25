package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class IntType extends AbstractType {

    private static IntType instance;

    public IntType(int line, int column) {
        super(line, column);
    }

    public static IntType getInstance() {
        if (instance == null) {
            instance = new IntType(0,0);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type asBuiltInType(ASTNode ast) {

        return IntType.getInstance();
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast) {

        Type newType = instance.promotesTo(type, ast);
        if (newType instanceof ErrorType)
            return super.arithmetic(type, ast);
        return newType;
    }

    @Override
    public Type arithmetic(ASTNode ast) {
        return IntType.getInstance();
    }

    @Override
    public Type logic(Type type, ASTNode ast) {

        if (type.equals(IntType.getInstance())) { return IntType.getInstance(); }
        return super.comparison(type, ast);
    }

    @Override
    public Type logic(ASTNode ast) {

        return IntType.getInstance();
    }

    @Override
    public Type promotesTo(Type type, ASTNode ast) {

        if (type instanceof ErrorType)
            return type;
        if (this.getClass() == type.getClass())
            return this;
        return new ErrorType(ast.getLine(), ast.getColumn(), "Cannot promote " + this + " to " + type);
    }

    @Override
    public Type canBeCastTo(Type type, ASTNode ast) {

        if (type.isBuiltInType(ast)) { return type; }
        return super.canBeCastTo(type, ast);
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {

        if (type.isBuiltInType(ast)) { return IntType.getInstance(); }
        return super.comparison(type, ast);
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public boolean isBuiltInType(ASTNode ast){
        return true;
    }

    @Override
    public boolean isLogical(ASTNode ast){
        return true;
    }

    @Override
    public char suffix() { return 'i'; }
}
