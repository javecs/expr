package xyz.javecs.tools.expr

import kotlin.collections.HashMap

class Calculator(expressions: Array<String> = emptyArray()) : EvalContext {
    private val evaluator = EvalVisitor(this)
    private val variables = HashMap<String, Double>()
    private val constants = constant()
    private val functions = builtIn()
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
        variables.clear()
        expression = Expression()
    }

    override fun toString() = expression.toString()
    override fun isConstant(name: String) = constants.contains(name.toLowerCase())
    override fun call(name: String, value: Double) = functions.getOrDefault(name.toLowerCase(), { Double.NaN })(value)
    override fun get(name: String) = constants.getOrDefault(name.toLowerCase(), variables.getOrDefault(name, Double.NaN))
    override fun put(name:String, value: Double) = when (isConstant(name)) {
        true -> Double.NaN
        else -> {
            variables[name] = value
            value
        }
    }
}