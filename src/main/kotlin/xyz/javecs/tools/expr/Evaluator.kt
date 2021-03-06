@file:JvmName("Evaluator")

package xyz.javecs.tools.expr

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import xyz.javecs.tools.expr.parser.ExprLexer
import xyz.javecs.tools.expr.parser.ExprParser

internal fun parser(expr: String): ExprParser {
    val input = CharStreams.fromString(expr)
    val lexer = ExprLexer(input)
    val tokens = CommonTokenStream(lexer)
    return ExprParser(tokens)
}

internal fun parserTree(expr: String): String {
    val parser = parser(expr)
    val tree = parser.start()
    return tree.toStringTree(parser)
}

fun eval(expr: String): Number {
    return EvalVisitor(Calculator()).visit(parser(expr).start()).getValue()
}