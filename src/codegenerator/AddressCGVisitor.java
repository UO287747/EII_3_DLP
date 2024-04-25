package codegenerator;

import ast.definitions.VarDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.StructAccess;
import ast.expressions.Variable;
import ast.types.IntType;
import ast.types.StructType;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {

    CodeGenerator cg;
    ValueCGVisitor vv;

    public AddressCGVisitor(CodeGenerator codeGenerator) {

        this.cg = codeGenerator;
    }

    public void setvv(ValueCGVisitor vv) {
        this.vv = vv;
    }

    /**
     * address[[Variable: expression -> ID]]() =
     *      if (expression.definition.scope==0) {
     *              <pusha> expression.definition.offset
     *      } else {
     *              <push bp>
     *              <pushi> expression.definition.offset
     *              <addi>
     *      }
     *      load expression.definition.type.suffix()
     */
    @Override
    public Void visit(Variable ast, Void param) {

        if (ast.getDefinition().getScope() == 0) {
            this.cg.pusha(((VarDefinition) ast.getDefinition()).getOffset());
        } else {
            this.cg.pushBP();
            this.cg.push(((VarDefinition) ast.getDefinition()).getOffset());
            this.cg.add(IntType.getInstance());
        }
        return null;
    }

    /**
     * address[[Indexing: expression1 -> expression2 expression3]]() =
     *      address[[expression2]]
     *      value[[expression3]]
     *      <pushi> expression1.type.numberOfBytes()
     *      <muli>
     *      <addi>
     */
    @Override
    public Void visit(ArrayAccess ast, Void param) {

        ast.getLeft().accept(this, param);
        ast.getRight().accept(this.vv, param);
        cg.push(ast.getType().numberOfBytes());
        cg.mul(IntType.getInstance());
        cg.add(IntType.getInstance());
        return null;
    }

    /**
     * address[[StructAccess: expression1 -> expression2 ID]]() =
     *      address[[expression2]]
     *      <pushi> expression2.type.getField(expression1.getName()).offset
     *      <addi>
     */
    @Override
    public Void visit(StructAccess ast, Void param) {

        ast.getExpression().accept(this, param);
        cg.push(((StructType)ast.getExpression().getType()).getField(ast.getName()).getOffset());
        cg.add(IntType.getInstance());
        return null;
    }
}
