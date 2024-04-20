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

    /**
     * address[[Variable: expression -> ID]]() =
     * if (expression.definition.scope==0) {
     *      <pusha> expression.definition.offset
     * } else {
     *      <push bp>
     *      <pushi> expression.definition.offset
     *      <addi>
     * }
     */
    @Override
    public Void visit(Variable ast, Void p) {

        if (ast.getDefinition().getScope() == 0) {
            this.cg.pusha(((VarDefinition) ast.getDefinition()).getOffset());
        } else {
            this.cg.pushBP();
            this.cg.push(((VarDefinition) ast.getDefinition()).getOffset());
            this.cg.add(IntType.getInstance());
        }
        return null;
    }
}
