package codegenerator;

public class AddressCGVisitor extends AbstractCGVisitor<Void,Void> {

    CodeGenerator cg;

    ValueCGVisitor vv;

    public AddressCGVisitor(CodeGenerator codeGenerator) {

        this.cg = codeGenerator;
    }
}
