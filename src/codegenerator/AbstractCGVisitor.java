package codegenerator;

import ast.Program;
import ast.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public abstract class AbstractCGVisitor<TP,TR> implements Visitor<TP,TR> {

   public TR visit(Program e, TP param) { throw new IllegalStateException(); }
   public TR visit(RecordField e, TP param) { throw new IllegalStateException(); }

   public TR visit(FuncDefinition e, TP param) { throw new IllegalStateException(); }
   public TR visit(VarDefinition e, TP param) { throw new IllegalStateException(); }

   public TR visit(Arithmetic e, TP param) { throw new IllegalStateException(); }
   public TR visit(ArrayAccess e, TP param) { throw new IllegalStateException(); }
   public TR visit(Cast e, TP param) { throw new IllegalStateException(); }
   public TR visit(CharLiteral e, TP param) { throw new IllegalStateException(); }
   public TR visit(Comparison e, TP param) { throw new IllegalStateException(); }
   public TR visit(FuncInvocation e, TP param) { throw new IllegalStateException(); }
   public TR visit(IntLiteral e, TP param) { throw new IllegalStateException(); }
   public TR visit(Logic e, TP param) { throw new IllegalStateException(); }
   public TR visit(RealLiteral e, TP param) { throw new IllegalStateException(); }
   public TR visit(StructAccess e, TP param) { throw new IllegalStateException(); }
   public TR visit(UnaryMinus e, TP param) { throw new IllegalStateException(); }
   public TR visit(UnaryNot e, TP param) { throw new IllegalStateException(); }
   public TR visit(Variable e, TP param) { throw new IllegalStateException(); }

   public TR visit(Assignment e, TP param) { throw new IllegalStateException(); }
   public TR visit(IfElse e, TP param) { throw new IllegalStateException(); }
   public TR visit(Input e, TP param) { throw new IllegalStateException(); }
   public TR visit(Print e, TP param) { throw new IllegalStateException(); }
   public TR visit(Return e, TP param) { throw new IllegalStateException(); }
   public TR visit(While e, TP param) { throw new IllegalStateException(); }

   public TR visit(ArrayType e, TP param) { throw new IllegalStateException(); }
   public TR visit(CharType e, TP param) { throw new IllegalStateException(); }
   public TR visit(DoubleType e, TP param) { throw new IllegalStateException(); }
   public TR visit(ErrorType e, TP param) { throw new IllegalStateException(); }
   public TR visit(FunctionType e, TP param) { throw new IllegalStateException(); }
   public TR visit(IntType e, TP param) { throw new IllegalStateException(); }
   public TR visit(StructType e, TP param) { throw new IllegalStateException(); }
   public TR visit(VoidType e, TP param) { throw new IllegalStateException(); } 
}
