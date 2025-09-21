import java.util.HashMap;
import java.util.Map;

public class AgregarProductos {

    // Mapa para almacenar productos y sus cantidades en el carrito de compra
    private Map<String, Integer> carrito;

    public AgregarProductos() {
        this.carrito = new HashMap<>();
    }

    // Agrega un producto con la cantidad especificada al carrito
    public void agregarProducto(String producto, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad debe ser mayor que cero.");
            return;
        }
        int cantidadActual = carrito.getOrDefault(producto, 0);
        carrito.put(producto, cantidadActual + cantidad);
        System.out.println("Producto agregado: " + producto + " - Cantidad: " + (cantidadActual + cantidad));
    }

    // Elimina un producto completamente del carrito
    public void eliminarProducto(String producto) {
        if (carrito.containsKey(producto)) {
            carrito.remove(producto);
            System.out.println("Producto eliminado: " + producto);
        } else {
            System.out.println("Producto no encontrado en el carrito.");
        }
    }

    // Modifica la cantidad de un producto en el carrito
    public void modificarCantidadProducto(String producto, int nuevaCantidad) {
        if (!carrito.containsKey(producto)) {
            System.out.println("Producto no encontrado en el carrito.");
            return;
        }
        if (nuevaCantidad <= 0) {
            eliminarProducto(producto);
        } else {
            carrito.put(producto, nuevaCantidad);
            System.out.println("Cantidad modificada: " + producto + " - Nueva cantidad: " + nuevaCantidad);
        }
    }

    // Muestra todos los productos y cantidades en el carrito
    public void mostrarCarrito() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        System.out.println("\nProductos en el carrito:");
        for (Map.Entry<String, Integer> entry : carrito.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

    // Método main para pruebas simples
    public static void main(String[] args) {
        AgregarProductos carritoCompras = new AgregarProductos();

        carritoCompras.agregarProducto("Manzanas", 3);
        carritoCompras.agregarProducto("Pan", 2);
        carritoCompras.mostrarCarrito();

        carritoCompras.modificarCantidadProducto("Pan", 5);
        carritoCompras.eliminarProducto("Manzanas");

        carritoCompras.mostrarCarrito();
    }
}
