package xyz.javecs.tools.expr

internal fun builtIn() = HashMap<String, (Double) -> Double>().apply {
    put("sin", { x -> Math.sin(x) })
    put("cos", { x -> Math.cos(x) })
    put("tan", { x -> Math.tan(x) })
    put("asin", { x -> Math.asin(x) })
    put("acos", { x -> Math.acos(x) })
    put("atan", { x -> Math.atan(x) })
    put("sinh", { x -> Math.sinh(x) })
    put("cosh", { x -> Math.cosh(x) })
    put("tanh", { x -> Math.tanh(x) })
    put("exp", { x -> Math.exp(x) })
    put("log", { x -> Math.log(x) })
    put("log10", { x -> Math.log10(x) })
    put("sqrt", { x -> Math.sqrt(x) })
    put("rad", { x -> Math.toRadians(x) })
    put("deg", { x -> Math.toDegrees(x) })
}
