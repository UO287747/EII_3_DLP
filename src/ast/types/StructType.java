package ast.types;

import ast.ASTNode;
import ast.AbstractASTNode;
import ast.RecordField;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType {

    private List<RecordField> recordFields;

    public StructType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = recordFields;
    }

    public List<RecordField> getRecordFields() {
        return recordFields;
    }

    @Override
    public String toString() {
        return "Struct{" +
                "line=" + line +
                ", column=" + column +
                ", recordFields=" + recordFields +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type dot(String id, ASTNode ast) {

        for (RecordField recordField: recordFields) {
            if (recordField.getName().equals(id)) {
                return recordField.getType();
            }
        }
        return super.dot(id, ast);
    }

    @Override
    public int numberOfBytes() {

        int nOB = 0;
        for (RecordField rf: recordFields) {
            nOB += rf.getType().numberOfBytes();
        }
        return nOB;
    }
}
