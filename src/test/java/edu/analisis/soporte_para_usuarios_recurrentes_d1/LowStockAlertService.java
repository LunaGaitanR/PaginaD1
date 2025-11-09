package edu.analisis.soporte_para_usuarios_recurrentes_d1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowStockAlertServiceTest {

    @Test
    @DisplayName("Sin alertas cuando todas las cantidades están por encima del umbral")
    void noGeneraAlertasCuandoNoHayBajos() {
        // Dado: umbral por defecto = 5
        LowStockAlertService service = new LowStockAlertService(5);

        // Stock de ejemplo (usar TreeMap para orden determinista en la prueba)
        Map<String, Integer> stock = new TreeMap<>(Map.of(
                "SKU-ARROZ-500", 12,
                "SKU-AZU-1K", 9,
                "SKU-DET-ASEO", 6
        ));

        // Cuando
        List<String> obtenido = service.evaluate(stock);

        // Entonces
        List<String> esperado = List.of(); // vacío
        System.out.println("[OK noAlertas] esperado=" + esperado + " obtenido=" + obtenido);
        assertEquals(esperado, obtenido, "No debería haber alertas");
    }

    @Test
    @DisplayName("Genera alertas para items con cantidad <= umbral")
    void generaAlertasParaBajos() {
        // Dado: umbral por defecto = 5 (se alerta cuando qty <= 5)
        LowStockAlertService service = new LowStockAlertService(5);

        // Stock mixto: algunos por encima, otros en/bajo el umbral
        Map<String, Integer> stock = new TreeMap<>(Map.of(
                "SKU-LECHE-1L", 3,   // alerta (<=5)
                "SKU-HUEVOS-30", 10, // ok
                "SKU-PAN-TRAD", 5,   // alerta (==5)
                "SKU-JABON-ASEO", 0  // alerta (==0)
        ));

        // Cuando
        List<String> obtenido = service.evaluate(stock);

        // Entonces: como usamos TreeMap y los SKUs son distintos,
        // el orden de las alertas será lexicográfico por clave.
        List<String> esperado = List.of(
                "LOW_STOCK: sku=SKU-JABON-ASEO qty=0 threshold=5",
                "LOW_STOCK: sku=SKU-LECHE-1L qty=3 threshold=5",
                "LOW_STOCK: sku=SKU-PAN-TRAD qty=5 threshold=5"
        );

        System.out.println("[OK conAlertas] esperado=" + esperado + " obtenido=" + obtenido);
        assertEquals(esperado, obtenido, "Valor esperado vs obtenido no coincide");
    }
}
