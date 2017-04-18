package xyz.javecs.tools.expr

import kotlin.collections.HashMap

class Calculator(expressions: Array<String> = emptyArray()) : EvalContext {
    private val evaluator = EvalVisitor(this)
    private val symbol: HashMap<String, Double> = HashMap()
    private val function = builtIn()
    private var expression = Expression()
    var value: Number = expression.value
        get() = expression.getValue()

    init {
        for (expr in expressions) {
            eval(expr)
        }
    }

    fun eval(expr: String = ""): Calculator {
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

    fun clear() {
        symbol.clear()
        expression = Expression()
    }

    override fun get(name: String): Double = symbol.getOrDefault(name, Double.NaN)
    override fun put(name:String, value: Double) {
        symbol[name] = value
    }
    override fun call(name: String, value: Double) = function.getOrDefault(name.toLowerCase(), { Double.NaN })(value)

    override fun toString(): String {
        return expression.toString()
    }
}