@file:JvmName("Evaluator")

package xyz.javecs.tools.expr

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import xyz.javecs.tools.expr.parser.ExprLexer
import xyz.javecs.tools.expr.parser.ExprParser

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
    return EvalVisitor(Calculator()).visit(parser(expr).start()).getValue()
}