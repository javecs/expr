package xyz.javecs.tools.expr

class Environment {
    private val functions: HashMap<String, Function> = HashMap()
    fun register(f: Function) {
        functions.put(f.name, f)
        f.setEnvironment(this)
    }
    fun isRegistered(name: String) = functions.containsKey(name)
    fun invoke(name: String, args: Array<Double>) = functions[name]!!.call(args)
}