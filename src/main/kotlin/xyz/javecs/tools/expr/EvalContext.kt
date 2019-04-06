package xyz.javecs.tools.expr

internal interface EvalContext {
    fun get(name: String): Double
    fun put(name: String, value: Double): Double
    fun call(name: String, args: Array<Double>): Double
    fun isConstant(name: String): Boolean
}
