package ast;

public class RecordField extends AbstractASTNode {

    private String name;
    private Type type;

    public RecordField(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() { return type; }

    @Override
    public String toString() {
        return "RecordField{" +
                "line=" + line +
                ", column=" + column +
                ", name='" + name + '\'' +
                '}';
    }
}
