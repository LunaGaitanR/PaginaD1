import java.util.HashMap;
import java.util.Map;

public class GestionCategorias {

    // Mapa que almacena categorias: id y nombre de categoria
    private Map<Integer, String> categorias;
    // Contador para ID automático de categoría
    private int contadorId;

    public GestionCategorias() {
        this.categorias = new HashMap<>();
        this.contadorId = 1; // Inicio IDs desde 1
    }

    // Crear una nueva categoría y devolver su ID asignado
    public int crearCategoria(String nombreCategoria) {
        if (nombreCategoria == null || nombreCategoria.trim().isEmpty()) {
            System.out.println("El nombre de la categoría no puede ser vacío.");
            return -1;
        }
        int idCategoria = contadorId++;
        categorias.put(idCategoria, nombreCategoria);
        System.out.println("Categoría creada: ID = " + idCategoria + ", Nombre = " + nombreCategoria);
        return idCategoria;
    }

    // Modificar el nombre de una categoría existente dado su ID
    public boolean modificarCategoria(int idCategoria, String nuevoNombre) {
        if (!categorias.containsKey(idCategoria)) {
            System.out.println("Categoría con ID " + idCategoria + " no encontrada.");
            return false;
        }
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            System.out.println("El nuevo nombre no puede estar vacío.");
            return false;
        }
        categorias.put(idCategoria, nuevoNombre);
        System.out.println("Categoría modificada: ID = " + idCategoria + ", Nuevo nombre = " + nuevoNombre);
        return true;
    }

    // Eliminar una categoría por ID
    public boolean eliminarCategoria(int idCategoria) {
        if (!categorias.containsKey(idCategoria)) {
            System.out.println("Categoría con ID " + idCategoria + " no encontrada.");
            return false;
        }
        categorias.remove(idCategoria);
        System.out.println("Categoría eliminada: ID = " + idCategoria);
        return true;
    }

    // Mostrar todas las categorías
    public void mostrarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
            return;
        }
        System.out.println("\nCategorías disponibles:");
        for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " - Nombre: " + entry.getValue());
        }
    }

    // Método main para pruebas básicas
    public static void main(String[] args) {
        GestionCategorias gestion = new GestionCategorias();

        int id1 = gestion.crearCategoria("Bebidas");
        int id2 = gestion.crearCategoria("Snacks");
        gestion.mostrarCategorias();

        gestion.modificarCategoria(id1, "Bebidas y Jugos");
        gestion.eliminarCategoria(id2);

        gestion.mostrarCategorias();
    }
}
