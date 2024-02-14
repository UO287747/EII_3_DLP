package ast.expressions;

import ast.Expression;
import ast.Type;

public class Cast extends AbstractExpresion {

    private Type type;
    private Expression expression;

    public Cast(int line, int column, Expression expression, Type type) {
        super(line, column);
        this.type = type;
        this.expression = expression;
    }

    public Type getType() {
        return type;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "type=" + type +
                ", expression=" + expression +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
