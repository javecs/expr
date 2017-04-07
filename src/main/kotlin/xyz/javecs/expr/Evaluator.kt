package xyz.javecs.expr

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import xyz.javecs.expr.parser.ExprBaseVisitor
import xyz.javecs.expr.parser.ExprLexer
import xyz.javecs.expr.parser.ExprParser

class EvalVisitor : ExprBaseVisitor<Double>() {
    override fun visitNumber(ctx: ExprParser.NumberContext?): Double {
        return ctx!!.NUMBER().text.toDouble()
    }

    override fun visitAdd(ctx: ExprParser.AddContext?): Double {
        val left = visit(ctx!!.expr(0))
        val right = visit(ctx.expr(1))
        return left + right
    }

    override fun visitSub(ctx: ExprParser.SubContext?): Double {
        val left = visit(ctx!!.expr(0))
        val right = visit(ctx.expr(1))
        return left - right
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
    if (value == Math.floor(value)) {
        return when {
            value < Int.MAX_VALUE -> value.toInt()
            else -> value.toLong()
        }
    }
    return value
}