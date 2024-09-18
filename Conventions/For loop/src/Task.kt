class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current: MyDate = start //La fecha actual


            // Avanzamos a la siguiente fecha
            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException() // Lanza una excepcion si no hay mas fechas
                val result = current // Guarda la fecha acutal en una variable inmutable
                current = current.followingDate() // Avanzamos a la siguiente fecha
                return result; // Retornamos la fecha actual
            }

            // Verificamos si aun hay mas fechas por recorrer
            override fun hasNext(): Boolean = current <= end
        }
    }

}
    fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
        for (date in firstDate..secondDate) {
            handler(date)
        }
    }

