package xyz.javecs.tools.expr

internal interface EvalContext {
    fun get(name: String): Double
    fun put(name:String, value: Double)
    fun call(name: String, value: Double): Double
}
