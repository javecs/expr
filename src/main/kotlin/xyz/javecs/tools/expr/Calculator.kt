package xyz.javecs.tools.expr

import kotlin.collections.HashMap

class Calculator(expressions: Array<String> = emptyArray()) : EvalContext {
    private val evaluator = EvalVisitor(this)
    private val variables = HashMap<String, Double>()
    private val constants = constant()
    private var expression = Expression()
    var environment = Environment()
    var value: Number = expression.value
        get() = expression.getValue()

    init {
        expressions.forEach { eval(it) }
    }

    private fun callFunction(name: String, args: Array<Double>) = if (environment.isRegistered(name)) {
        environment.invoke(name, args)
    } else {
        invoke(name.toLowerCase(), args)
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

    fun plugin(f: Function): Calculator {
        environment.register(f)
        return this
    }

    fun clear() {
        variables.clear()
        expression = Expression()
    }

    fun variables(): Map<String, Double> = variables

    override fun toString() = expression.toString()
    override fun isConstant(name: String) = constants.contains(name.toLowerCase())
    override fun call(name: String, args: Array<Double>) = callFunction(name, args)
    override fun get(name: String) = constants.getOrDefault(name.toLowerCase(), variables.getOrDefault(name, Double.NaN))
    override fun put(name:String, value: Double) = when (isConstant(name)) {
        true -> Double.NaN
        else -> {
            variables[name] = value
            value
        }
    }
}