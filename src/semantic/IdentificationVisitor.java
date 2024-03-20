package semantic;

import ast.Definition;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void,Void> {

    private SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(FuncDefinition e, Void param) {

        if ( !symbolTable.insert(e) )
            new ErrorType(e.getLine(), e.getColumn(), "Error: La función " + e.getName() + " ya está definida.");

        symbolTable.set();

        e.getType().accept(this, param);

        for (VarDefinition varDefinition: e.getVarDefinitions())
            varDefinition.accept(this, param);
        for (Statement statement: e.getStatements())
            statement.accept(this, param);

        symbolTable.reset();

        return null;
    }

    @Override
    public Void visit(Variable e, Void param) {

        Definition definition = symbolTable.find(e.getName());

        if ( definition == null )
            definition = new VarDefinition(e.getLine(), e.getColumn(),
                    new ErrorType(e.getLine(), e.getColumn(), "Error: La variable " + e.getName() + " no está definida."), e.getName());

        e.setDefinition(definition);

        return null;
    }

    @Override
    public Void visit(VarDefinition e, Void param) {

        if ( !symbolTable.insert(e) )
            new ErrorType(e.getLine(), e.getColumn(), "Error: La variable " + e.getName() + " ya está definida.");

        e.getType().accept(this, param);

        return null;
    }
}
