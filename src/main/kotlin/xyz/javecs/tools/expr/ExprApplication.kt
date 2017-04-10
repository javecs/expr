package xyz.javecs.tools.expr

fun main(args: Array<String>) {
    val expr = "3 + 4"
    println(parserTree(expr))
    println(eval(expr))
}
