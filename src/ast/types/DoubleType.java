package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType {

    private static DoubleType instance;

    public DoubleType(int line, int column) {
        super(line, column);
    }

    public static DoubleType getInstance() {
        if (instance == null) {
            instance = new DoubleType(0,0);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "real";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
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
        return DoubleType.getInstance();
    }

    @Override
    public Type promotesTo(Type type, ASTNode ast) {

        if (type.equals(DoubleType.getInstance())) { return type; }
        return super.promotesTo(type, ast);
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
        return 4;
    }

    @Override
    public boolean isBuiltInType(ASTNode ast){
        return true;
    }

    @Override
    public char suffix() { return 'f'; }
}
