package xyz.javecs.tools.expr

import kotlin.streams.toList

private val sPattern = Regex("[a-zA-Z][a-zA-Z0-9]*\\s*\\(\\s*([a-zA-Z][a-zA-Z0-9]*\\s*(,\\s*[a-zA-Z][a-zA-Z0-9]*)*)?\\s*\\)")
internal fun validate(signature: String): Pair<String, Array<String>> {
    if (!sPattern.matches(signature.trim())) throw Exception()
    val separated = signature.replace(" ", "").split("(", ",", ")").stream().filter { !it.isBlank() }.toList()
    return Pair(separated[0], if (separated.size > 1) {
        separated.subList(1, separated.size).toTypedArray()
    } else {
        emptyArray()
    })
}

class Function(signature: String, val codes: Array<String>) {
    private val calc = Calculator()
    val name = validate(signature).first
    val params = validate(signature).second
    fun setEnvironment(environment: Environment) {
        calc.environment = environment
    }
    fun call(args: Array<Double>): Double {
        if (params.size != args.size) return Double.NaN
        calc.clear()
        params.indices.forEach( { calc.eval("${params[it]} = ${args[it]}") })
        codes.forEach( { calc.eval(it) })
        return calc.value.toDouble()
    }
}