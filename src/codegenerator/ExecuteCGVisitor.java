package codegenerator;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void,Void> {

    CodeGenerator cg;

    AddressCGVisitor av;
    ValueCGVisitor vv;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {

        this.cg = codeGenerator;
    }
}
