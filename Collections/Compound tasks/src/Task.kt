// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders
        .filter(Order::isDelivered)     // Filtra solo los pedidos entregado
        .flatMap(Order::products)       // Obtén todos los productos de esos pedidos
        .maxByOrNull(Product::price)    // Encuentra el producto más caro
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
        .flatMap(Customer::getOrderedProducts)      // Obtener todos los productos que han pedido los clientes
        .count { it == product }                    // Cuenta cuántas veces coincide con el producto
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)
