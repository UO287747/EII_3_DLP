package codegenerator;

import ast.Type;

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


}
