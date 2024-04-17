package codegenerator;

public class ValueCGVisitor extends AbstractCGVisitor<Void,Void> {

    CodeGenerator cg;

    AddressCGVisitor av;

    public ValueCGVisitor(CodeGenerator codeGenerator) {

        this.cg = codeGenerator;
    }
}
