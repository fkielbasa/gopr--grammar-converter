package generated;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Route;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/generated/alerts.txt";
        String outputFilePath = "src/generated/output.txt";

        // String tString = "d2 ^ (w3) V (f3) V (a4 V a5)";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter alert: ");
        String tString = scanner.nextLine();
        scanner.close();

        try (PrintStream fileOut = new PrintStream(new FileOutputStream(outputFilePath))) {
            fileOut.println(tString + "\n");

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

            MyExprListener listener = new MyExprListener(fileOut);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, program);

            Map<String, String> alerts = AlertsLoader.loadAlerts(filePath);

            String cleanedTString = tString.replace("^", "").replaceFirst(" ", "").trim();

            String alertValue = findBestMatchingAlert(cleanedTString, alerts);

            Map<String, String> conditions = parseConditions(cleanedTString);

            String routeName = "Route 1";
            String routeDifficulty = mapAlertToLevel(alertValue);

            String json = generateJson(routeName, routeDifficulty, alertValue, conditions);
            fileOut.println("\n" + json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(MyColors.ANSI_RED + tString + MyColors.ANSI_RESET + "\n");

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

        MyExprListener listener = new MyExprListener(System.out);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, program);

        Map<String, String> alerts = AlertsLoader.loadAlerts(filePath);

        String cleanedTString = tString.replace("^", "").replaceFirst(" ", "").trim();

        String alertValue = findBestMatchingAlert(cleanedTString, alerts);

        Map<String, String> conditions = parseConditions(cleanedTString);

        String routeName = "Route 1";
        String routeDifficulty = mapAlertToLevel(alertValue);

        String json = generateJson(routeName, routeDifficulty, alertValue, conditions);
        System.out.println("\n" + MyColors.ANSI_GREEN + json + MyColors.ANSI_RESET);
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
    private static String mapAlertToLevel(String alertValue) {
        switch (alertValue) {
            case "E1":
            case "E2":
                return "good";
            case "E3":
                return "moderate";
            case "E4":
            case "E5":
                return "bad";
            default:
                return "unknown";
        }
    }

    private static String generateJson(String routeName, String routeDifficulty, String alert, Map<String, String> conditions) {
        Route route = new Route(routeName, routeDifficulty, alert, conditions);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(route);
    }
}
