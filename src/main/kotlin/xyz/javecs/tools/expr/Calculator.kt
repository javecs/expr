package xyz.javecs.tools.expr

import kotlin.collections.HashMap

class Calculator(expressions: Array<String> = emptyArray()) : EvalContext {
    private val evaluator = EvalVisitor(this)
    private val symbol: HashMap<String, Double> = HashMap()
    private var expression = Expression()
    var value: Number = Double.NaN
        get() = expression.getValue()

    init {
        for (expr in expressions) {
            evaluate(expr)
        }
    }

    fun evaluate(expr: String = ""): Calculator {
        expression = when (expr.isEmpty()) {
            true -> expression
            else -> {
                val evaluated = evaluator.visit(parser(expr).start())
                evaluated.expr = expr
                evaluated
            }
        }
        return this
    }

    override fun getSymbol(name: String): Double = symbol.getOrDefault(name, Double.NaN)
    override fun putSymbol(name:String, value: Double) {
        symbol[name] = value
    }

    override fun toString(): String {
        return expression.toString()
    }
}