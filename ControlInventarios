import java.util.HashMap;
import java.util.Map;

public class ControlInventarios {

    // Mapa para almacenar productos y sus cantidades en inventario
    private Map<String, Integer> inventario;
    // Umbral mínimo para alertar falta o escasez del producto
    private int umbralAlerta;

    // Constructor con umbral de alerta configurable
    public ControlInventarios(int umbralAlerta) {
        this.inventario = new HashMap<>();
        this.umbralAlerta = umbralAlerta;
    }

    // Agregar o actualizar stock de un producto
    public void actualizarStock(String producto, int cantidad) {
        inventario.put(producto, cantidad);
        System.out.println("Stock actualizado: " + producto + " = " + cantidad);
    }

    // Reducir stock tras venta o salida
    public boolean reducirStock(String producto, int cantidad) {
        if (!inventario.containsKey(producto)) {
            System.out.println("Producto no existe en inventario.");
            return false;
        }
        int stockActual = inventario.get(producto);
        if (stockActual < cantidad) {
            System.out.println("No hay suficiente stock para el producto: " + producto);
            return false;
        }
        inventario.put(producto, stockActual - cantidad);
        System.out.println("Stock reducido: " + producto + " = " + (stockActual - cantidad));
        verificarInventarioBajo(producto);
        return true;
    }

    // Verificar stock bajo y alertar
    private void verificarInventarioBajo(String producto) {
        int cantidad = inventario.get(producto);
        if (cantidad <= umbralAlerta) {
            System.out.println("Alerta: Stock bajo para producto " + producto + ". Cantidad actual: " + cantidad);
        }
    }

    // Consultar cantidad disponible de un producto
    public int consultarStock(String producto) {
        return inventario.getOrDefault(producto, 0);
    }

    // Mostrar inventario completo (para administración)
    public void mostrarInventario() {
        System.out.println("\nInventario actual:");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

    // Método main para prueba básica
    public static void main(String[] args) {
        ControlInventarios control = new ControlInventarios(5); // Alerta si stock <= 5

        control.actualizarStock("Arroz", 10);
        control.actualizarStock("Azúcar", 4);

        control.reducirStock("Arroz", 6);
        control.reducirStock("Azúcar", 2);
        control.reducirStock("Leche", 1); // Producto no existe

        control.mostrarInventario();
    }
}
