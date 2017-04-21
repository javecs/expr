package xyz.javecs.tools.expr

class Function(val name: String, val params: Array<String>) {
    private val calc = Calculator()
    private val codes = ArrayList<String>()

    fun code(code: String) {
        codes.add(code)
    }

    fun call(args: Array<Double>): Double {
        if (params.size != args.size) {
            return Double.NaN
        }

        calc.clear()
        for (i in params.indices) {
            calc.eval("${params[i]} = ${args[i]}")
        }
        codes.forEach( { calc.eval(it) })
        return calc.value.toDouble()
    }
}