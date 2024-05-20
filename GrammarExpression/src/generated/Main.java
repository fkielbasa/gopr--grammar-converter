import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String tString = "d4 ^ (w2 V w3) V (f2 V f3) V (t2 V t3) V (r2 V r3) V (a2 V a3 V a4 V a5)";

//        String tString = "d4 ^ (w2 V w3) (f2 V f3) (t2 V t3) (r2 V r3) (a2 V a3 V a4 V a5)";
//        CharStream stream = CharStreams.fromString(tString);
//        ExprLexer lexer = new ExprLexer(stream);
//        ExprParser parser = new ExprParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));
//
//        ExprParser.ProgramContext program = null;
//        try {
//            program = parser.program();
//        } catch (RecognitionException e) {
//            throw new RuntimeException(e);
//        }
//
//        MyExprListener listener = new MyExprListener();
//        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk(listener, program);

        // Przechowujemy alerty i ich wartości w mapie
        Map<String, String> alerts = new HashMap<>();
        alerts.put("d4 (w2 V w3) V (f2 V f3) V (t2 V t3) V (r2 V r3) V (a2 V a3 V a4 V a5)", "E5");
        alerts.put("d3 (w2 V w3) V ( f2 V f3) V (t3) V (r2 V r3) V (a3 V a4 V a5)", "E5");
        alerts.put("d2 (w3) V (f3) V (t3) V (r3) V (a4 V a5)", "E5");
        alerts.put("d1 (w3) V (f3) V (r3) V (a4 V a5)", "E5");
        alerts.put("d4 (w2 V w3) V (f2 V f3) V (t3) V (r2 V r3) V (a2 V a3 V a4 V a5)", "E4");
        alerts.put("d3 (w2 V w3) V (f2 V f3) V (t3) V (r3) V (a3 V a4 V a5)", "E4");
        alerts.put("d2 (w3) V (f3) V (r3) V (a4 V a5)", "E4");
        alerts.put("d1 (w3) V (r3) V (a4 V a5)", "E4");
        alerts.put("d4 (w2 V w3) V (f2 V f3) V (t3) V (r3) V (a2 V a3 V a4 V a5)", "E3");
        alerts.put("d3 (w2 V w3) V (f3) V (t3) V (r3) V (a3 V a4 V a5)", "E3");
        alerts.put("d2 (w3) V (f3) V (a4 V a5)", "E3");
        alerts.put("d1 (w3) V (a4 V a5)", "E3");
        alerts.put("d4 (w2 V w3) V (f3) V (t3) V (r3) V (a2 V a3 V a4 V a5)", "E2");
        alerts.put("d3 (w2 V w3) V (f3) V (t3) V (a3 V a4 V a5)", "E2");
        alerts.put("d2 (w3) V (a4 V a5)", "E2");
        alerts.put("d1 (a4 V a5)", "E2");
        alerts.put("E1", "E1");

        // Sprawdzamy, czy tString pasuje do któregoś z alertów
        String alertValue = alerts.getOrDefault(tString, "Unknown");

        // Zakładamy, że MyExprListener wypełnia poniższe pola
        String routeName = "Example Route";
        String routeDifficulty = "Moderate";

        Map<String, String> conditions = new HashMap<>();
        conditions.put("wind", "w3");  // Pobiera warunek pogodowy z listenera
        conditions.put("fog", "f3");
        conditions.put("temperature", "t3");
        conditions.put("rain", "r3");
        conditions.put("avalancheRisk", "a4 V a5");

        // Generowanie JSON-a ręcznie
        String json = generateJson(routeName, routeDifficulty, alertValue, conditions);
        System.out.println(json);
    }

    private static String generateJson(String routeName, String routeDifficulty, String alert, Map<String, String> conditions) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");

        json.append("  \"routeName\": \"").append(routeName).append("\",\n");
        json.append("  \"routeDifficulty\": \"").append(routeDifficulty).append("\",\n");
        json.append("  \"alert\": \"").append(alert).append("\",\n");

        json.append("  \"conditions\": {\n");
        for (Map.Entry<String, String> entry : conditions.entrySet()) {
            json.append("    \"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\",\n");
        }
        // Remove the last comma
        json.deleteCharAt(json.lastIndexOf(","));
        json.append("\n  }\n");

        json.append("}");
        return json.toString();
    }
}
