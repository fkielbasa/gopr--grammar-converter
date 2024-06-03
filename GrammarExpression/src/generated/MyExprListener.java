package generated;

import generated.ExprBaseListener;
import generated.ExprParser;

public class MyExprListener extends ExprBaseListener {
    @Override
    public void enterLabel(ExprParser.LabelContext ctx) {
        System.out.println("Label: " + ctx.getText());
    }

    @Override
    public void enterExpression(ExprParser.ExpressionContext ctx) {
        System.out.println("Expression: " + ctx.getText());
    }

    @Override
    public void enterSubexpression(ExprParser.SubexpressionContext ctx) {
        System.out.println("Subexpression: " + ctx.getText());
    }

}
