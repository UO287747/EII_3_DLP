package codegenerator;

import ast.RecordField;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.StructType;
import visitor.AbstractVisitor;

public class OffSetVisitor extends AbstractVisitor<Void,Void> {

    private int sizeGlobalVar;
    private int sizeLocalVar;

    @Override
    public Void visit(FuncDefinition e, Void param) {

        sizeLocalVar = 0;
        e.getType().accept(this, param);
        for (VarDefinition varDef: e.getVarDefinitions())
            varDef.accept(this, param);
        for (Statement statement: e.getStatements())
            statement.accept(this, param);
        return null;
    }

    @Override
    public Void visit(VarDefinition e, Void param) {

        if (e.getScope() == 0) {
            e.setOffset(sizeGlobalVar);
            sizeGlobalVar += e.getType().numberOfBytes();
        } else {
            sizeLocalVar -= e.getType().numberOfBytes();
            e.setOffset(sizeLocalVar);
        }
        e.getType().accept(this, param);
        return null;
    }

    @Override
    public Void visit(FunctionType e, Void param) {

        int size = 4;
        for (int i = e.getParams().size()-1; i >= 0; i--) {
            e.getParams().get(i).setOffset(size);
            size += e.getParams().get(i).getType().numberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(StructType e, Void param) {

        int size = 0;
        for (RecordField recordField: e.getRecordFields()) {
            recordField.setOffset(size);
            size += recordField.getType().numberOfBytes();
            recordField.accept(this, param);
        }
        return null;
    }
}
