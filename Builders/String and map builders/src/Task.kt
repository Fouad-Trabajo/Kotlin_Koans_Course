import java.util.HashMap

// Función que construye un HashMap usando una función literal con receptor
fun <K,V> buildMutableMap(build: HashMap<K, V>.() -> Unit ): HashMap<K, V> {
    //Crear un nuevo  HashMap
    val map = HashMap<K, V>()

    //Aplicar la función literal de extensión para modificar el HashMap
    map.build()

    //Devulve el hashMap resultante
    return map
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
