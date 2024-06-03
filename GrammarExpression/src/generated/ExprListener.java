package generated;// Generated from C:/Users/kubad/Documents/GitHub/gopr-grammar-converter/GrammarExpression/src/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#subexpression}.
	 * @param ctx the parse tree
	 */
	void enterSubexpression(ExprParser.SubexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#subexpression}.
	 * @param ctx the parse tree
	 */
	void exitSubexpression(ExprParser.SubexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(ExprParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(ExprParser.LabelContext ctx);
}
