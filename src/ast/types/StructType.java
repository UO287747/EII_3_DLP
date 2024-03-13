package ast.types;

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
}
