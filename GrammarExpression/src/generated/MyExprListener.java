public class MyExprListener extends ExprBaseListener {
    private String alert;
    private String wind;
    private String fog;
    private String temperature;
    private String rain;
    private String avalancheRisk;

    @Override
    public void exitExpression(ExprParser.ExpressionContext ctx) {
        // Implementacja logiki wyodrębniania danych z parsera
        alert = ctx.label().getText();  // Na przykład
        wind = extractCondition(ctx, "w");
        fog = extractCondition(ctx, "f");
        temperature = extractCondition(ctx, "t");
        rain = extractCondition(ctx, "r");
        avalancheRisk = extractCondition(ctx, "a");
    }

    private String extractCondition(ExprParser.ExpressionContext ctx, String condition) {
        // Implementacja logiki wyodrębniania konkretnych warunków
        return ctx.getText().contains(condition) ? "true" : "false";
    }

    public String getAlert() {
        return alert;
    }

    public String getWind() {
        return wind;
    }

    public String getFog() {
        return fog;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getRain() {
        return rain;
    }

    public String getAvalancheRisk() {
        return avalancheRisk;
    }
}
