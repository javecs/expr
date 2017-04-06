package xyz.javecs.expr

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import xyz.javecs.expr.parser.ExprLexer
import xyz.javecs.expr.parser.ExprParser

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

fun main(args: Array<String>) {
    println(parserTree("3 + 4"))
}