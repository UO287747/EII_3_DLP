package codegenerator;

import ast.Definition;
import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Input;
import ast.statements.Print;
import ast.types.FunctionType;

public class ExecuteCGVisitor extends AbstractCGVisitor<FuncDefinition,Void> {

    CodeGenerator cg;

    AddressCGVisitor av;
    ValueCGVisitor vv;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {

        this.cg = codeGenerator;
        this.av = new AddressCGVisitor(cg);
        this.av.setvv(vv);
        this.vv = new ValueCGVisitor(cg);
        this.vv.setav(av);
    }

    /**
     * execute[[Program: program -> definition*]]() =
     * for (Definition definition : definition*) {
     *      if (definition instanceof VarDefinition) {
     *          execute[[definition]]()
     *      }
     * }
     * <call main>
     * <halt>
     * for (Definition definition : definition*) {
     *      if (definition instanceof FuncDefinition) {
     *          execute[[definition]]()
     *      }
     * }
     */
    @Override
    public Void visit(Program ast, FuncDefinition param) {

        for (Definition definition : ast.getDefinitions()) {
            if (definition instanceof VarDefinition) {
                definition.accept(this, param);
            }
        }
        cg.callMain();
        cg.halt();
        for (Definition definition : ast.getDefinitions()) {
            if (definition instanceof FuncDefinition) {
                definition.accept(this, param);
            }
        }
        return null;
    }

    /**
     * execute[[FuncDefinition: funcDefinition -> ID type VarDefinition* statement*]]() =
     * ID:
     * ' * Parameters:
     * execute[[type]]()
     * ' * Local variables:
     * VarDefinition*.forEach(varDef -> execute[[varDef]]())
     * definition.bytesLocals = VarDefinition*.isEmpty() ? 0 : -VarDefinition*.get(VarDefinition*.size() - 1).offset
     * <enter> definition.bytesLocals
     * definition.type.bytesParams = varDefinitions.stream().mapToInt(varDef -> varDef.getType().numberOfBytes()).sum();
     * definition.type.bytesReturns = type.returnType.numberOfBytes();
     * statement*.forEach(stmnt -> execute[[stmnt]](FuncDefinition))
     * if (definition.bytesReturn == 0) {
     *      <ret> definition.getBytesReturn(), definition.getBytesLocals(), definition.type.getBytesParams()
     * }
     */
    @Override
    public Void visit(FuncDefinition ast, FuncDefinition param) {

        cg.info(" "+ast.getName()+":");
        cg.info("\t' * Parameters");
        ast.getType().accept(this, param);
        cg.info("\t' * Local variables");
        ast.getVarDefinitions().forEach(varDef -> varDef.accept(this, param));
        ast.setLocalBytes(ast.getVarDefinitions().isEmpty() ? 0 : -ast.getVarDefinitions().get(ast.getVarDefinitions().size() - 1).getOffset());
        cg.enter(ast.getLocalBytes());

        ((FunctionType) ast.getType()).setParamBytes(((FunctionType) ast.getType()).getParams().stream().mapToInt(params -> params.getType().numberOfBytes()).sum());
        ((FunctionType) ast.getType()).setRetBytes(((FunctionType) ast.getType()).getReturnType().numberOfBytes());
        ast.getStatements().forEach(stmt -> stmt.accept(this, ast));

        if (((FunctionType) ast.getType()).getRetBytes() == 0) {
            cg.ret(((FunctionType) ast.getType()).getRetBytes(), ast.getLocalBytes(), ((FunctionType) ast.getType()).getParamBytes());
        }
        return null;
    }

    /**
     * execute[[VarDefinition: definition -> ID type]]()
     */
    @Override
    public Void visit(VarDefinition ast, FuncDefinition param) {

        cg.info("\t' * "+ast.getType().toString() + " " + ast.getName() + " (offset " + ast.getOffset() + ")");
        return null;
    }

    /**
     * execute[[FunctionType: type -> VarDefinition* type]]() =
     * VarDefinition*.forEach(varDef -> execute[[varDef]]())
     */
    @Override
    public Void visit(FunctionType ast, FuncDefinition param) {

        ast.getParams().forEach(varDef -> varDef.accept(this, param));
        return null;
    }

    /**
     * execute[[Assignment: statement -> expression1 expression2]]() =
     * address[[expression1]]()
     * value[[expression2]]()
     * cg.convertTo(expression2.type, expression1.type)
     * <store> expression1.type.suffix()
     */
    @Override
    public Void visit(Assignment ast, FuncDefinition param) {

        cg.info("\t' * Assignment");
        ast.getLeft().accept(this.av, null);
        ast.getRight().accept(this.vv, null);
        cg.convertTo(ast.getRight().getType(), ast.getLeft().getType());
        cg.store(ast.getLeft().getType());
        return null;
    }

    /**
     * execute[[Print: statement -> expression]]() =
     * value[[expression]]()
     * <out> expression.type.suffix()
     */
    @Override
    public Void visit(Print ast, FuncDefinition param) {

        cg.info("\t' * Write");
        ast.getExpression().accept(this.vv, null);
        cg.out(ast.getExpression().getType());
        return null;
    }

    /**
     * execute[[Input: statement -> expression]]() =
     * address[[expression]]()
     * <in> expression.type.suffix()
     * <store> expression.type.suffix()
     */
    @Override
    public Void visit(Input ast, FuncDefinition param) {

        cg.info("\t' * Read");
        ast.getExpression().accept(this.av, null);
        cg.in(ast.getExpression().getType());
        cg.store(ast.getExpression().getType());
        return null;
    }
}
