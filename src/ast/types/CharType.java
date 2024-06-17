package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class CharType extends AbstractType {

    private static CharType instance;

    private CharType(int line, int column) {
        super(line, column);
    }

    public static CharType getInstance() {
        if (instance == null) {
            instance = new CharType(0,0);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type arithmetic(Type type, ASTNode ast) {

        if (type instanceof CharType)
            return IntType.getInstance();
        return super.arithmetic(type, ast);
    }

    @Override
    public Type arithmetic(ASTNode ast) {
        return IntType.getInstance();
    }

    @Override
    public Type promotesTo(Type type, ASTNode ast) {

        if (type instanceof ErrorType)
            return type;
        if (type.equals(CharType.getInstance()))
            return this;
        return super.promotesTo(type, ast);
    }

    @Override
    public Type canBeCastTo(Type type, ASTNode ast) {

        if (type.isBuiltInType(ast)) { return type; }
        return super.canBeCastTo(type, ast);
    }

    @Override
    public Type comparison(Type type, ASTNode ast) {

        if(type instanceof CharType){
            return type;
        }
        return super.comparison(type, ast);
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public boolean isBuiltInType(ASTNode ast){
        return true;
    }

    @Override
    public char suffix() { return 'b'; }
}
