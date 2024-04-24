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
    int label;

    public CodeGenerator(String outputFileName, String inputFileName) throws FileNotFoundException {

        this.out = new PrintWriter(outputFileName);
    }

    // Push
    public void pushBP() {

        out.println("\tpush\tbp");
        out.flush();
    }

    public void push(char c) {

        out.println("\tpushb\t" + (int) c);
        out.flush();
    }

    public void push(int i) {

        out.println("\tpushi\t" + i);
        out.flush();
    }

    public void pushf(double d) {

        out.println("\tpushf\t" + d);
        out.flush();
    }

    public void pusha(int a) {

        out.println("\tpusha\t" + a);
        out.flush();
    }


    // Pop
    public void pop(Type type) {

        out.println("\tpop" + type.suffix());
        out.flush();
    }


    // Dup
    public void dup(Type type) {

        out.println("\tdup" + type.suffix());
        out.flush();
    }


    // Load
    public void load(Type type) {

        out.println("\tload" + type.suffix());
        out.flush();
    }

    // Store
    public void store(Type type) {

        out.println("\tstore" + type.suffix());
        out.flush();
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

        out.println("\tadd" + type.suffix());
        out.flush();
    }

    public void sub(Type type) {

        out.println("\tsub" + type.suffix());
        out.flush();
    }

    public void mul(Type type) {

        out.println("\tmul" + type.suffix());
        out.flush();
    }

    public void div(Type type) {

        out.println("\tdiv" + type.suffix());
        out.flush();
    }

    public void mod(Type type) {

        out.println("\tmod" + type.suffix());
        out.flush();
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
        out.flush();
    }

    public void gt(Type type) {

        out.println("\tgt" + type.suffix());
        out.flush();
    }

    public void lt(Type type) {

        out.println("\tlt" + type.suffix());
        out.flush();
    }

    public void ge(Type type) {

        out.println("\tge" + type.suffix());
        out.flush();
    }

    public void le(Type type) {

        out.println("\tle" + type.suffix());
        out.flush();
    }

    public void eq(Type type) {

        out.println("\teq" + type.suffix());
        out.flush();
    }

    public void ne(Type type) {

        out.println("\tne" + type.suffix());
        out.flush();
    }


    // Logical
    public void logic(String op) {

        switch (op) {
            case "&&" -> and();
            case "!" -> not();
            case "||" -> or();
        }
        out.flush();
    }

    public void and() {

        out.println("\tand");
        out.flush();
    }

    public void or() {

        out.println("\tor");
        out.flush();
    }

    public void not() {

        out.println("\tnot");
        out.flush();
    }


    // Output
    public void out(Type type) {

        out.println("\tout" + type.suffix());
        out.flush();
    }


    // Input
    public void in(Type type) {

        out.println("\tin" + type.suffix());
        out.flush();
    }


    // Conversions
    public void convertTo(Type type, Type convertType) {

        if (type.equals(IntType.getInstance())) {
            if (convertType.equals(CharType.getInstance())) {
                out.println("\ti2b");
            } else if (convertType.equals(DoubleType.getInstance())) {
                out.println("\ti2f");
            }

        } else if (type.equals(DoubleType.getInstance())) {
            if (convertType.equals(IntType.getInstance())) {
                out.println("\tf2i");
            } else if (convertType.equals(CharType.getInstance())) {
                out.println("\tf2i");
                out.println("\ti2b");
            }

        } else if (type.equals(CharType.getInstance())) {
            if (convertType.equals(IntType.getInstance())) {
                out.println("\tb2i");
            } else if (convertType.equals(DoubleType.getInstance())) {
                out.println("\tb2i");
                out.println("\ti2f");
            }
        }
        out.flush();
    }


    // Jumps
    public void jmp(int label) {

        out.println("\tjmp\t" + label);
        out.flush();
    }

    public void jz(int label) {

        out.println("\tjz\t" + label);
        out.flush();
    }

    public void jnz(int label) {

        out.println("\tjnz\t" + label);
        out.flush();
    }


    // Functions
    public void call(String id) {

        out.println("\tcall\t" + id);
        out.flush();
    }

    public void callMain() {

        out.println("\n' Invocation to the main function");
        out.println("call main");
        out.flush();
    }

    public void enter(int bytesLocals) {

        out.println("\tenter\t" + bytesLocals);
        out.flush();
    }

    public void ret(int retBytes, int locBytes, int paramBytes) {

        out.println("\tret\t" + retBytes + ", " + locBytes + ", " + paramBytes);
        out.flush();

    }

    public void halt() {

        out.println("halt\n");
        out.flush();
    }

    // OP info
    public void info(String text) {

        out.println(text);
        out.flush();
    }

    public int getLabel() {
        return label++;
    }
    
}
