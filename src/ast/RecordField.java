package ast;

public class RecordField extends AbstractASTNode {

    private String name;

    public RecordField(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RecordField{" +
                "line=" + line +
                ", column=" + column +
                ", name='" + name + '\'' +
                '}';
    }
}
