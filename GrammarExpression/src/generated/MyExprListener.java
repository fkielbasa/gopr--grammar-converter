package generated;

import java.io.PrintStream;

public class MyExprListener extends ExprBaseListener {
    private final PrintStream out;
    private final boolean isConsole;

    public MyExprListener(PrintStream out) {
        this.out = out;
        this.isConsole = out.equals(System.out);
    }

    @Override
    public void enterLabel(ExprParser.LabelContext ctx) {
        if (isConsole) {
            out.println(MyColors.ANSI_CYAN + "Label: " + ctx.getText() + MyColors.ANSI_RESET);
        } else {
            out.println("Label: " + ctx.getText());
        }
    }

    @Override
    public void enterExpression(ExprParser.ExpressionContext ctx) {
        if (isConsole) {
            out.println(MyColors.ANSI_BLUE + "Expression: " + ctx.getText() + MyColors.ANSI_RESET);
        } else {
            out.println("Expression: " + ctx.getText());
        }
    }

    @Override
    public void enterSubexpression(ExprParser.SubexpressionContext ctx) {
        if (isConsole) {
            out.println(MyColors.ANSI_PURPLE + "Subexpression: " + ctx.getText() + MyColors.ANSI_RESET);
        } else {
            out.println("Subexpression: " + ctx.getText());
        }
    }
}
