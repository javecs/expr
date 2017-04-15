package xyz.javecs.tools.expr

class Expression(var value: Double = Double.NaN, var expr: String = "", var id: String = "") {
    fun getValue(): Number {
        return if (value == Math.floor(value)) {
            when {
                value < Int.MAX_VALUE -> value.toInt()
                else -> value.toLong()
            }
        } else value
    }
}