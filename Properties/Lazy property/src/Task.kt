class LazyProperty(val initializer: () -> Int) {
    private var lazyValue: Int? = null // Variable privada que guarda el valor "perezoso" (lazy)
    val lazy: Int
        get() {
            if (lazyValue == null){         // Si el valor aún no ha sido inicializado
                lazyValue = initializer()   // Invoca initializer() para calcular el valor
            }
            return lazyValue!! //No es null, pero de serlo se lanza una excepción en tiempo de ejecución
        }
}
