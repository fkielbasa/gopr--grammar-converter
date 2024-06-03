package generated;

import generated.ExprBaseListener;
import generated.ExprParser;

public class MyExprListener extends ExprBaseListener {
    @Override
    public void enterLabel(ExprParser.LabelContext ctx) {
        System.out.println(MyColors.ANSI_CYAN + "Label: " + ctx.getText() + MyColors.ANSI_RESET);
    }

    @Override
    public void enterExpression(ExprParser.ExpressionContext ctx) {
        System.out.println(MyColors.ANSI_BLUE + "Expression: " + ctx.getText() + MyColors.ANSI_RESET);
    }

    @Override
    public void enterSubexpression(ExprParser.SubexpressionContext ctx) {
        System.out.println(MyColors.ANSI_PURPLE + "Subexpression: " + ctx.getText() + MyColors.ANSI_RESET);

    }

}
