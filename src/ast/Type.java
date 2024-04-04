package ast;

import java.util.List;

public interface Type extends ASTNode {

    Type asBuiltInType(ASTNode ast);

    Type asLogical(ASTNode ast);

    Type arithmetic(Type type, ASTNode ast);

    Type arithmetic(ASTNode ast);

    Type logic(Type type, ASTNode ast);

    Type logic(ASTNode ast);

    Type promotesTo(Type type, ASTNode ast);

    Type canBeCastTo(Type type, ASTNode ast);

    Type comparison(Type type, ASTNode ast);

    Type squareBrackets(Type type, ASTNode ast);

    Type dot(String id, ASTNode ast);

    Type parenthesis(List<Type> list, ASTNode ast);
}
