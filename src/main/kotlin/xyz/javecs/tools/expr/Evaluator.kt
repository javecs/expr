package xyz.javecs.tools.expr

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import xyz.javecs.tools.expr.parser.ExprBaseVisitor
import xyz.javecs.tools.expr.parser.ExprLexer
import xyz.javecs.tools.expr.parser.ExprParser

class EvalVisitor : ExprBaseVisitor<Double>() {
    override fun visitParens(ctx: ExprParser.ParensContext?) = visit(ctx!!.expr())!!
    override fun visitNumber(ctx: ExprParser.NumberContext?) = ctx!!.NUMBER().text.toDouble()
    override fun visitAdd(ctx: ExprParser.AddContext?) = visit(ctx!!.expr(0)) + visit(ctx.expr(1))
    override fun visitSub(ctx: ExprParser.SubContext?) = visit(ctx!!.expr(0)) - visit(ctx.expr(1))
    override fun visitMul(ctx: ExprParser.MulContext?) = visit(ctx!!.expr(0)) * visit(ctx.expr(1))
    override fun visitDiv(ctx: ExprParser.DivContext?): Double {
        val left = visit(ctx!!.expr(0))
        val right = visit(ctx.expr(1))
        return if (right == 0.0) Double.NaN else left / right
    }
}

fun parser(expr: String): ExprParser {
    val input = ANTLRInputStream(expr.byteInputStream())
    val lexer = ExprLexer(input)
    val tokens = CommonTokenStream(lexer)
    return ExprParser(tokens)
}

fun parserTree(expr: String): String {
    val parser = parser(expr)
    val tree = parser.start()
    return tree.toStringTree(parser)
}

fun eval(expr: String): Number {
    val value = EvalVisitor().visit(parser(expr).start())
    return if (value == Math.floor(value)) {
        when {
            value < Int.MAX_VALUE -> value.toInt()
            else -> value.toLong()
        }
    } else value
}