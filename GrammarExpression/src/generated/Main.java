package generated;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Route;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
//        String tString = "d2 ^ (w3) V (f3) V (a4 V a5)";
        String filePath = "src/generated/alerts.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter alert: ");
        String tString = scanner.nextLine();
        scanner.close();



        String t2String = removeVsOutsideParentheses(tString);

        CharStream stream = CharStreams.fromString(t2String);
        ExprLexer lexer = new ExprLexer(stream);
        ExprParser parser = new ExprParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));

        ExprParser.ProgramContext program = null;
        try {
            program = parser.program();
        } catch (RecognitionException e) {
            throw new RuntimeException(e);
        }

        MyExprListener listener = new MyExprListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, program);

        ////////////////////////////////////////////

//        // Przechowujemy alerty i ich wartości w mapie, używając LinkedHashMap do zachowania kolejności
//        Map<String, String> alerts = new LinkedHashMap<>();
//        alerts.put("d4 (w2 V w3) V (f2 V f3) V (t2 V t3) V (r2 V r3) V (a2 V a3 V a4 V a5)", "E5");
//        alerts.put("d3 (w2 V w3) V (f2 V f3) V (t3) V (r2 V r3) V (a3 V a4 V a5)", "E5");
//        alerts.put("d2 (w3) V (f3) V (t3) V (r3) V (a4 V a5)", "E5");
//        alerts.put("d1 (w3) V (f3) V (r3) V (a4 V a5)", "E5");
//        alerts.put("d4 (w2 V w3) V (f2 V f3) V (t3) V (r2 V r3) V (a2 V a3 V a4 V a5)", "E4");
//        alerts.put("d3 (w2 V w3) V (f2 V f3) V (t3) V (r3) V (a3 V a4 V a5)", "E4");
//        alerts.put("d2 (w3) V (f3) V (r3) V (a4 V a5)", "E4");
//        alerts.put("d1 (w3) V (r3) V (a4 V a5)", "E4");
//        alerts.put("d4 (w2 V w3) V (f2 V f3) V (t3) V (r3) V (a2 V a3 V a4 V a5)", "E3");
//        alerts.put("d3 (w2 V w3) V (f3) V (t3) V (r3) V (a3 V a4 V a5)", "E3");
//        alerts.put("d2 (w3) V (f3) V (a4 V a5)", "E3");
//        alerts.put("d1 (w3) V (a4 V a5)", "E3");
//        alerts.put("d4 (w2 V w3) V (f3) V (t3) V (r3) V (a2 V a3 V a4 V a5)", "E2");
//        alerts.put("d3 (w2 V w3) V (f3) V (t3) V (a3 V a4 V a5)", "E2");
//        alerts.put("d2 (w3) V (a4 V a5)", "E2");
//        alerts.put("d1 (a4 V a5)", "E2");
//        alerts.put("E1", "E1");

        Map<String, String> alerts = AlertsLoader.loadAlerts(filePath);

        String cleanedTString = tString.replace("^", "").replaceFirst(" ", "").trim();

        String alertValue = findBestMatchingAlert(cleanedTString, alerts);

        Map<String, String> conditions = parseConditions(cleanedTString);

        String routeName = "Example Route";
        String routeDifficulty = "Moderate";

        String json = generateJson(routeName, routeDifficulty, alertValue, conditions);
        System.out.println(ANSI_GREEN + json + ANSI_RESET);

    }

    private static String removeVsOutsideParentheses(String t2String) {
        StringBuilder result = new StringBuilder();
        int parenthesisCount = 0;

        for (char c : t2String.toCharArray()) {
            if (c == '(') {
                parenthesisCount++;
            } else if (c == ')') {
                parenthesisCount--;
            }

            if (parenthesisCount > 0 || c != 'V') {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static Map<String, String> parseConditions(String tString) {
        Map<String, String> conditions = new HashMap<>();
        String[] parts = tString.split("\\(|\\)\\s*V\\s*\\(|\\)");

        for (String part : parts) {
            part = part.trim();
            if (part.startsWith("w")) {
                conditions.put("wind", part);
            } else if (part.startsWith("f")) {
                conditions.put("fog", part);
            } else if (part.startsWith("t")) {
                conditions.put("temperature", part);
            } else if (part.startsWith("r")) {
                conditions.put("rain", part);
            } else if (part.startsWith("a")) {
                conditions.put("avalancheRisk", part);
            }
        }
        return conditions;
    }

    private static String findBestMatchingAlert(String cleanedTString, Map<String, String> alerts) {
        for (Map.Entry<String, String> entry : alerts.entrySet()) {
            if (entry.getKey().contains(cleanedTString)) {
                return entry.getValue();
            }
        }
        return "Unknown";
    }

//    private static String generateJson(String routeName, String routeDifficulty, String alert, Map<String, String> conditions) {
//        StringBuilder json = new StringBuilder();
//        json.append("{\n");
//
//        json.append("  \"routeName\": \"").append(routeName).append("\",\n");
//        json.append("  \"routeDifficulty\": \"").append(routeDifficulty).append("\",\n");
//        json.append("  \"alert\": \"").append(alert).append("\",\n");
//
//        json.append("  \"conditions\": {\n");
//        for (Map.Entry<String, String> entry : conditions.entrySet()) {
//            json.append("    \"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\",\n");
//        }
//        // Remove the last comma
//        json.deleteCharAt(json.lastIndexOf(","));
//        json.append("\n  }\n");
//
//        json.append("}");
//        return json.toString();
//    }
    private static String generateJson(String routeName, String routeDifficulty, String alert, Map<String, String> conditions) {
        Route route = new Route(routeName, routeDifficulty, alert, conditions);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(route);
    }
}
