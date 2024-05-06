import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        String tString = "d3 ^ (w2 V w3) (f2 V f3) (t3) (r3) (a3 V a4 V a5) ";
        CharStream stream = CharStreams.fromString(tString);
        ExprLexer lexer = new ExprLexer(stream);
        ExprParser parser = new ExprParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));

        ExprParser.ProgramContext program = parser.program();

        MyExprListener listener = new MyExprListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, program);


    }
}
