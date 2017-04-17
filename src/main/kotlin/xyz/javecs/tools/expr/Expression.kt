package xyz.javecs.tools.expr

internal class Expression(var value: Double = Double.NaN, var expr: String = "", var id: String = "") {
    fun getValue(): Number = if (value == Math.floor(value)) {
        when {
            value < Int.MAX_VALUE -> value.toInt()
            else -> value.toLong()
        }
    } else value

    override fun toString(): String = if (id.isEmpty()) getValue().toString() else "$id = ${getValue()}"
}