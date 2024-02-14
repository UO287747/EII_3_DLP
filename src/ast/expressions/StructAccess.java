package ast.expressions;

import ast.Expression;

public class StructAccess extends AbstractExpresion {

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
}
