// Generated from C:/Users/kubad/Documents/GitHub/gopr-grammar-converter/GrammarExpression/src/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#subexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpression(ExprParser.SubexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(ExprParser.LabelContext ctx);
}