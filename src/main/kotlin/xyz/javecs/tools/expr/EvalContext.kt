package xyz.javecs.tools.expr

interface EvalContext {
    fun getSymbol(name: String): Double
    fun putSymbol(name:String, value: Double)
}