class LazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
    //La palabra clave "by lazy" hace que lazyValue ejecute initializer()
    // solo cuando la accedes por primera vez
}

