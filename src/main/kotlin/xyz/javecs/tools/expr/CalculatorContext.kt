package xyz.javecs.tools.expr

interface CalculatorContext {
    fun getSymbol(name: String): Number?
    fun putSymbol(name:String, value: Number)
}