// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders.asSequence() //Convertimos la lista de clientes en una secuencia
        .filter(Order::isDelivered)
        .flatMap(Order::products)
        .maxByOrNull(Product::price)
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.asSequence() //Convertimos la lista de clientes en una secuencia
        .flatMap(Customer::getOrderedProducts) //convertimos la lista de productos en una secuencia
        .count { it == product }  // contamos cuántas veces coincide con el producto
}

fun Customer.getOrderedProducts(): Sequence<Product> =
    orders.asSequence().flatMap(Order::products) //Convertimos la lista de productos en una secuencia
