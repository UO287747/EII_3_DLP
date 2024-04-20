package codegenerator;

import ast.expressions.*;
import ast.types.IntType;

public class ValueCGVisitor extends AbstractCGVisitor<Void,Void> {

    CodeGenerator cg;

    AddressCGVisitor av;

    public ValueCGVisitor(CodeGenerator codeGenerator) {

        this.cg = codeGenerator;
    }

    /**
     * value[[Arithmetic: expression1 -> expression2 (+|-|*|/|%) expression3]]() =
     * value[[expression2]]()
     * cg.convertTo(expression2.type, expression1.type)
     * value[[expression3]]()
     * cg.convertTo(expression3.type, expression1.type)
     * cg.arithmetic(expression1.op, expression1.type)
     */
    @Override
    public Void visit(Arithmetic ast, Void param) {

        ast.getLeft().accept(this, param);
        this.cg.convertTo(ast.getLeft().getType(), ast.getType());
        ast.getRight().accept(this, param);
        this.cg.convertTo(ast.getRight().getType(), ast.getType());
        this.cg.arithmetic(ast.getOP(), ast.getType());
        return null;
    }

    /**
     * value[[Cast: expression1-> type expression2]]() =
     * value[[expression2]]
     * cg.convertTo(expression2.type, type);
     */
    @Override
    public Void visit(Cast ast, Void param) {

        ast.getExpression().accept(this, param);
        this.cg.convertTo(ast.getExpression().getType(), ast.getType());
        return null;
    }

    /**
     * value[[CharLiteral: expression -> CHAR_CONSTANT]]() =
     * <pushb> CHAR_CONSTANT
     */
    @Override
    public Void visit(CharLiteral ast, Void param) {

        this.cg.push(ast.getValue());
        return null;
    }

    /**
     * value[[Comparison: expression1 -> expression2 (==|!=|>=|<=|>|<) expression3]]() =
     * value[[expression2]]()
     * cg.convertTo(expression2.type, expression1.type)
     * value[[expression3]]()
     * cg.convertTo(expression3.type, expression1.type)
     * cg.comparison(expression1.op, expression1.type)
     */
    @Override
    public Void visit(Comparison ast, Void param) {

        ast.getLeft().accept(this, param);
        this.cg.convertTo(ast.getLeft().getType(), ast.getType());
        ast.getRight().accept(this, param);
        this.cg.convertTo(ast.getRight().getType(), ast.getType());
        cg.comparison(ast.getOP(), ast.getType());
        return null;
    }

    /**
     * value[[IntLiteral: expression -> INT_CONSTANT]]() =
     * <pushi> INT_CONSTANT
     */
    @Override
    public Void visit(IntLiteral ast, Void param) {

        this.cg.push(ast.getValue());
        return null;
    }

    /**
     * value[[Logical: expression1 -> expression2 (&&|||) expression3]]() =
     * value[[expression2]]()
     * value[[expression3]]()
     * cg.logic(expression1.op)
     */
    @Override
    public Void visit(Logic ast, Void param) {

        ast.getLeft().accept(this, param);
        ast.getRight().accept(this, param);
        this.cg.logic(ast.getOP());
        return null;
    }

    /**
     * value[[RealLiteral: expression -> REAL_CONSTANT]]() =
     * <pushf> REAL_CONSTANT
     */
    @Override
    public Void visit(RealLiteral ast, Void param) {

        this.cg.pushf(ast.getValue());
        return null;
    }

    /**
     * value[[UnaryMinus: expression1 -> expression2]]() =
     * value[[expression2]]()
     * cg.convertTo(expression2.type, expression1.type)
     * <pushi> -1
     * cg.convertTo(IntType, expression1.type)
     * <mul> expression1.type.suffix()
     */
    @Override
    public Void visit(UnaryMinus ast, Void param) {

        ast.getExpression().accept(this, param);
        this.cg.convertTo(ast.getExpression().getType(), ast.getType());
        this.cg.push(-1);
        this.cg.convertTo(IntType.getInstance(), ast.getType());
        this.cg.mul(ast.getType());
        return null;
    }

    /**
     * value[[UnaryNot: expression1 -> expression2]]() =
     * value[[expression2]]()
     * cg.logical(expression1.operator)
     */
    @Override
    public Void visit(UnaryNot ast, Void param) {

        ast.getExpression().accept(this, param);
        this.cg.not();
        return null;
    }

    /**
     * value[[Variable: expression -> ID]]() =
     * address[[ID]]()
     * <load> expression.type.suffix()
     */
    @Override
    public Void visit(Variable ast, Void param) {

        ast.accept(this.av, param);
        this.cg.load(ast.getType());
        return null;
    }
}
