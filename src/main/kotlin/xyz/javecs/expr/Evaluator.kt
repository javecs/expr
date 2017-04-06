package xyz.javecs.expr

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import xyz.javecs.expr.parser.ExprBaseVisitor
import xyz.javecs.expr.parser.ExprLexer
import xyz.javecs.expr.parser.ExprParser

class EvalVistor : ExprBaseVisitor<Long>() {
    override fun visitInt(ctx: ExprParser.IntContext?): Long {
        return ctx!!.INT().text.toLong()
    }

    override fun visitAdd(ctx: ExprParser.AddContext?): Long {
        val left = visit(ctx!!.expr(0))
        val right = visit(ctx.expr(1))
        return left + right
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

fun eval(expr: String): Long = EvalVistor().visit(parser(expr).start())