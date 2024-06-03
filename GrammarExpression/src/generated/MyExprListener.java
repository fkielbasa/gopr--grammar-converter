public class MyExprListener extends ExprBaseListener {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    @Override
    public void enterLabel(ExprParser.LabelContext ctx) {
        System.out.println(ANSI_CYAN + "Label: " + ctx.getText() + ANSI_RESET);
    }

    @Override
    public void enterExpression(ExprParser.ExpressionContext ctx) {
        System.out.println(ANSI_BLUE + "Expression: " + ctx.getText() + ANSI_RESET);
    }

    @Override
    public void enterSubexpression(ExprParser.SubexpressionContext ctx) {
        System.out.println(ANSI_PURPLE + "Subexpression: " + ctx.getText() + ANSI_RESET);

    }

}
