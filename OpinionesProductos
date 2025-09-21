import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpinionesProductos {

    // Clase para representar una opinión de producto
    public static class Opinion {
        private String cliente;
        private String comentario;
        private int calificacion; // de 1 a 5 estrellas

        public Opinion(String cliente, String comentario, int calificacion) {
            this.cliente = cliente;
            this.comentario = comentario;
            setCalificacion(calificacion);
        }

        public String getCliente() {
            return cliente;
        }

        public String getComentario() {
            return comentario;
        }

        public int getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(int calificacion) {
            if (calificacion < 1) this.calificacion = 1;
            else if (calificacion > 5) this.calificacion = 5;
            else this.calificacion = calificacion;
        }

        @Override
        public String toString() {
            return "Cliente: " + cliente + ", Calificación: " + calificacion + "/5, Comentario: " + comentario;
        }
    }

    // Mapa para almacenar listas de opiniones por producto
    private Map<String, List<Opinion>> opinionesPorProducto;

    public OpinionesProductos() {
        opinionesPorProducto = new HashMap<>();
    }

    // Agregar opinión para un producto
    public void agregarOpinion(String producto, String cliente, String comentario, int calificacion) {
        opinionesPorProducto.putIfAbsent(producto, new ArrayList<>());
        Opinion opinion = new Opinion(cliente, comentario, calificacion);
        opinionesPorProducto.get(producto).add(opinion);
        System.out.println("Opinión agregada para producto: " + producto);
    }

    // Mostrar opiniones para un producto específico
    public void mostrarOpiniones(String producto) {
        List<Opinion> opiniones = opinionesPorProducto.get(producto);
        if (opiniones == null || opiniones.isEmpty()) {
            System.out.println("No hay opiniones para el producto: " + producto);
            return;
        }
        System.out.println("Opiniones para el producto: " + producto);
        for (Opinion op : opiniones) {
            System.out.println(op);
        }
    }

    // Método main para prueba de funcionalidades
    public static void main(String[] args) {
        OpinionesProductos opin = new OpinionesProductos();
        opin.agregarOpinion("Cafetera", "Juan", "Muy buen producto, fácil de usar.", 5);
        opin.agregarOpinion("Cafetera", "Ana", "No me gustó el sabor del café.", 2);
        opin.agregarOpinion("Tostadora", "Carlos", "Perfecta para mi cocina.", 4);

        opin.mostrarOpiniones("Cafetera");
        opin.mostrarOpiniones("Tostadora");
        opin.mostrarOpiniones("Licuadora"); // Sin opiniones
    }
}
