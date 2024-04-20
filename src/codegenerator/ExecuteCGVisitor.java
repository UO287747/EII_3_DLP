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
        this.cg.callMain();
        this.cg.halt();
        for (Definition definition : ast.getDefinitions()) {
            if (definition instanceof FuncDefinition) {
                definition.accept(this, param);
            }
        }
        return null;
    }

    /**
     * execute[[FuncDefinition: definition -> ID type VarDefinition* statement*]]() =
     * ID:
     * ' * Parameters:
     * execute[[type]]()
     * ' * Local variables:
     * VarDefinition*.forEach(varDef -> execute[[varDef]]())
     * definition.bytesLocals = VarDefinition*.isEmpty() ? 0 : -1 * VarDefinition*.get(VarDefinition*.size() - 1).offset
     * <enter> definition.bytesLocals
     * definition.type.bytesParams = varDefinitions.stream().mapToInt(varDef -> varDef.getType().numberOfBytes()).sum();
     * definition.type.bytesReturns = type.returnType.numberOfBytes();
     * statement*.forEach(stmnt -> execute[[stmnt]](FuncDefinition))
     * if (definition.bytesReturn === 0) {
     *      <ret> definition.getBytesReturn(), definition.getBytesLocals(), definition.type.getBytesParams()
     * }
     */
    @Override
    public Void visit(FuncDefinition ast, FuncDefinition param) {

        ast.getType().accept(this, param);
        ast.getVarDefinitions().forEach(varDef -> varDef.accept(this, param));
        ast.setLocalBytes(ast.getVarDefinitions().isEmpty() ? 0 : -1 * ast.getVarDefinitions().get(ast.getVarDefinitions().size() - 1).getOffset());
        this.cg.enter(ast.getLocalBytes());

        ((FunctionType) ast.getType()).setParamBytes(((FunctionType) ast.getType()).getParams().stream().mapToInt(varDef -> varDef.getType().numberOfBytes()).sum());
        ((FunctionType) ast.getType()).setRetBytes(((FunctionType) ast.getType()).getReturnType().numberOfBytes());
        ast.getStatements().forEach(statement -> statement.accept(this, ast));

        if (((FunctionType) ast.getType()).getRetBytes() == 0) {
            this.cg.ret(((FunctionType) ast.getType()).getRetBytes(), ast.getLocalBytes(), ((FunctionType) ast.getType()).getParamBytes());
        }
        return null;
    }

    /**
     * execute[[VarDefinition: definition -> ID type]]()
     */
    @Override
    public Void visit(VarDefinition ast, FuncDefinition param) {

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

        ast.getLeft().accept(this.av, null);
        ast.getRight().accept(this.vv, null);
        this.cg.convertTo(ast.getRight().getType(), ast.getLeft().getType());
        this.cg.store(ast.getLeft().getType());
        return null;
    }

    /**
     * execute[[Print: statement -> expression]]() =
     * value[[expression]]()
     * <out> expression.type.suffix()
     */
    @Override
    public Void visit(Print ast, FuncDefinition param) {

        ast.getExpression().accept(this.vv, null);
        this.cg.out(ast.getExpression().getType());
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

        ast.getExpression().accept(this.av, null);
        this.cg.in(ast.getExpression().getType());
        this.cg.store(ast.getExpression().getType());
        return null;
    }
}
