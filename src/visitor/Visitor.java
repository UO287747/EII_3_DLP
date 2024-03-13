package visitor;

import ast.Program;
import ast.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP,TR> {

    TR visit(Program e, TP param);
    TR visit(RecordField e, TP param);

    TR visit(FuncDefinition e, TP param);
    TR visit(VarDefinition e, TP param);

    TR visit(Arithmetic e, TP param);
    TR visit(ArrayAccess e, TP param);
    TR visit(Cast e, TP param);
    TR visit(CharLiteral e, TP param);
    TR visit(Comparison e, TP param);
    TR visit(FuncInvocation e, TP param);
    TR visit(IntLiteral e, TP param);
    TR visit(Logic e, TP param);
    TR visit(RealLiteral e, TP param);
    TR visit(StructAccess e, TP param);
    TR visit(UnaryMinus e, TP param);
    TR visit(UnaryNot e, TP param);
    TR visit(Variable e, TP param);

    TR visit(Assignment e, TP param);
    TR visit(IfElse e, TP param);
    TR visit(Input e, TP param);
    TR visit(Print e, TP param);
    TR visit(Return e, TP param);
    TR visit(While e, TP param);

    TR visit(ArrayType e, TP param);
    TR visit(CharType e, TP param);
    TR visit(DoubleType e, TP param);
    TR visit(ErrorType e, TP param);
    TR visit(FunctionType e, TP param);
    TR visit(IntType e, TP param);
    TR visit(StructType e, TP param);
    TR visit(VoidType e, TP param);
}
