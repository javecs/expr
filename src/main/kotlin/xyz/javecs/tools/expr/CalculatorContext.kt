package xyz.javecs.tools.expr

interface CalculatorContext {
    fun getSymbol(name: String): Double
    fun putSymbol(name:String, value: Double)
}