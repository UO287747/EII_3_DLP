package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class StructAccess extends AbstractExpression {

    private String field;
    private Expression expression;

    public StructAccess(int line, int column, Expression expression, String field) {
        super(line, column);
        this.field = field;
        this.expression = expression;
    }

    public String getName() {
        return field;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "StructAccess{" +
                "field='" + field + '\'' +
                ", expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
