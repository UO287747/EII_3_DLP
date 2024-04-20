package codegenerator;

import ast.Type;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.IntType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {

    PrintWriter out;

    public CodeGenerator(String outputFileName, String inputFileName) throws FileNotFoundException {

        this.out = new PrintWriter(outputFileName);
    }

    // Push
    public void pushBP() {

        this.out.println("push\t bp");
        this.out.flush();
    }

    public void pushb(char c) {

        this.out.println("pushb\t" + c);
        this.out.flush();
    }

    public void push(int i) {

        this.out.println("push\t" + i);
        this.out.flush();
    }

    public void pushf(double d) {

        this.out.println("pushf\t" + d);
        this.out.flush();
    }

    public void pusha(int a) {

        this.out.println("pusha\t" + a);
        this.out.flush();
    }


    // Pop
    public void pop(Type type) {

        this.out.println("pop" + type.suffix());
        this.out.flush();
    }


    // Dup
    public void dup(Type type) {

        this.out.println("dup" + type.suffix());
        this.out.flush();
    }


    // Load
    public void load(Type type) {

        this.out.println("load" + type.suffix());
        this.out.flush();
    }

    // Store
    public void store(Type type) {

        this.out.println("store" + type.suffix());
        this.out.flush();
    }


    // Arithmetic
    public void arithmetic(String op, Type type) {

        switch (op) {
            case "+" -> add(type);
            case "-" -> sub(type);
            case "*" -> mul(type);
            case "/" -> div(type);
            case "%" -> mod(type);
        }
    }

    public void add(Type type) {

        this.out.println("add" + type.suffix());
        this.out.flush();
    }

    public void sub(Type type) {

        this.out.println("sub" + type.suffix());
        this.out.flush();
    }

    public void mul(Type type) {

        this.out.println("mul" + type.suffix());
        this.out.flush();
    }

    public void div(Type type) {

        this.out.println("div" + type.suffix());
        this.out.flush();
    }

    public void mod(Type type) {

        this.out.println("mod" + type.suffix());
        this.out.flush();
    }


    // Comparison
    public void comparison(String op, Type type) {

        switch (op) {
            case "<" -> lt(type);
            case "<=" -> le(type);
            case ">" -> gt(type);
            case ">=" -> ge(type);
            case "==" -> eq(type);
            case "!=" -> ne(type);
        }
        this.out.flush();
    }

    public void gt(Type type) {

        this.out.println("gt" + type.suffix());
        this.out.flush();
    }

    public void lt(Type type) {

        this.out.println("lt" + type.suffix());
        this.out.flush();
    }

    public void ge(Type type) {

        this.out.println("ge" + type.suffix());
        this.out.flush();
    }

    public void le(Type type) {

        this.out.println("le" + type.suffix());
        this.out.flush();
    }

    public void eq(Type type) {

        this.out.println("eq" + type.suffix());
        this.out.flush();
    }

    public void ne(Type type) {

        this.out.println("ne" + type.suffix());
        this.out.flush();
    }


    // Logical
    public void logic(String op) {

        switch (op) {
            case "&&" -> and();
            case "!" -> not();
            case "||" -> or();
        }
        this.out.flush();
    }

    public void and() {

        this.out.println("and");
        this.out.flush();
    }

    public void or() {

        this.out.println("or");
        this.out.flush();
    }

    public void not() {

        this.out.println("not");
        this.out.flush();
    }


    // Output
    public void out(Type type) {

        this.out.println("out" + type.suffix());
        this.out.flush();
    }


    // Input
    public void in(Type type) {

        this.out.println("out" + type.suffix());
        this.out.flush();
    }


    // Conversions
    public void convertTo(Type type, Type convertType) {

        if (type.equals(IntType.getInstance())) {
            if (convertType.equals(CharType.getInstance())) {
                this.out.println("i2b");
            } else if (convertType.equals(DoubleType.getInstance())) {
                this.out.println("i2f");
            }

        } else if (type.equals(DoubleType.getInstance())) {
            if (convertType.equals(IntType.getInstance())) {
                this.out.println("f2i");
            } else if (convertType.equals(CharType.getInstance())) {
                this.out.println("f2i");
                this.out.println("i2b");
            }

        } else if (type.equals(CharType.getInstance())) {
            if (convertType.equals(IntType.getInstance())) {
                this.out.println("b2i");
            } else if (convertType.equals(DoubleType.getInstance())) {
                this.out.println("b2i");
                this.out.println("i2f");
            }
        }
        this.out.flush();
    }


    // Jumps
    public void jmp(int label) {

        this.out.println("jmp\t" + label);
        this.out.flush();
    }

    public void jz(int label) {

        this.out.println("jz\t" + label);
        this.out.flush();
    }

    public void jnz(int label) {

        this.out.println("jnz\t" + label);
        this.out.flush();
    }


    // Functions
    public void call(String id) {

        this.out.println("call\t" + id);
        this.out.flush();
    }

    public void callMain() {

        this.out.println("call main");
        this.out.flush();
    }

    public void enter(int bytesLocals) {

        this.out.println("enter\t" + bytesLocals);
        this.out.flush();
    }

    public void ret(int retBytes, int locBytes, int paramBytes) {

        this.out.println("ret\t" + retBytes + ", " + locBytes + ", " + paramBytes);
        this.out.flush();

    }

    public void halt() {

        this.out.println("halt\n");
        this.out.flush();
    }

}
