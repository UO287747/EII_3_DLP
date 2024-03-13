package ast.definitions;

import ast.AbstractASTNode;
import ast.Definition;
import ast.Type;
import examples.ast.ASTNode;
import visitor.Visitor;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    String name;
    Type type;

    public AbstractDefinition(int line, int column) {
        super(line, column);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
