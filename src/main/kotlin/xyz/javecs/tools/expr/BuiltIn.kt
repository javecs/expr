package xyz.javecs.tools.expr

internal fun constant() = HashMap<String, Double>().apply {
    put("pi", Math.PI)
    put("e", Math.E)
}

internal fun invoke(name: String, args: ArrayList<Double>) = when(name) {
    "sin" -> Math.sin(args[0])
    "cos" -> Math.cos(args[0])
    "tan" -> Math.tan(args[0])
    "asin" -> Math.asin(args[0])
    "acos" -> Math.acos(args[0])
    "atan" -> Math.atan(args[0])
    "sinh" -> Math.sinh(args[0])
    "cosh" -> Math.cosh(args[0])
    "tanh" -> Math.tanh(args[0])
    "exp" -> Math.exp(args[0])
    "log" -> Math.log(args[0])
    "log10" -> Math.log10(args[0])
    "sqrt" -> Math.sqrt(args[0])
    "rad" -> Math.toRadians(args[0])
    "deg" -> Math.toDegrees(args[0])
    "atan2" -> if (args.size == 2) Math.atan2(args[0], args[1]) else Double.NaN
    "hypot" -> if (args.size == 2) Math.hypot(args[0], args[1]) else Double.NaN
    "max" -> if (args.size == 2) Math.max(args[0], args[1]) else Double.NaN
    "min" -> if (args.size == 2) Math.min(args[0], args[1]) else Double.NaN
    else -> Double.NaN
}