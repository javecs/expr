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

    override fun visitMul(ctx: ExprParser.MulContext?): Double {
        val left = visit(ctx!!.expr(0))
        val right = visit(ctx.expr(1))
        return left * right
    }

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