package xyz.javecs.tools.expr

internal interface EvalContext {
    fun getSymbol(name: String): Double
    fun putSymbol(name:String, value: Double)
}