package edu.analisis.soporte_para_usuarios_recurrentes_d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Servicio simple que evalúa inventarios y genera alertas cuando
 * la cantidad es menor o igual al umbral definido.
 *
 * Diseño ilustrativo:
 *  - Recibe un umbral por defecto (defaultThreshold).
 *  - Método evaluate(stock) devuelve una lista de mensajes de alerta
 *    con formato determinista: "LOW_STOCK: sku=<SKU> qty=<QTY> threshold=<TH>"
 *  - No envía notificaciones reales; solo genera mensajes para que
 *    otras capas (email, Slack, etc.) decidan qué hacer.
 */
public final class LowStockAlertService {

    private final int defaultThreshold;

    public LowStockAlertService(int defaultThreshold) {
        if (defaultThreshold < 0) {
            throw new IllegalArgumentException("El umbral no puede ser negativo");
        }
        this.defaultThreshold = defaultThreshold;
    }

    public int defaultThreshold() {
        return defaultThreshold;
    }

    /**
     * Genera alertas para cada SKU con cantidad <= umbral.
     *
     * @param stock Mapa sku -> cantidad en inventario (no nulo, cantidades >= 0)
     * @return lista de mensajes de alerta (puede ser vacía)
     */
    public List<String> evaluate(Map<String, Integer> stock) {
        Objects.requireNonNull(stock, "stock no puede ser nulo");

        List<String> alerts = new ArrayList<>();
        // Usar el orden natural del mapa del llamador; en tests usaremos TreeMap para determinismo
        for (Map.Entry<String, Integer> e : stock.entrySet()) {
            String sku = e.getKey();
            Integer qty = e.getValue();
            if (sku == null || sku.isBlank()) {
                throw new IllegalArgumentException("SKU inválido");
            }
            if (qty == null || qty < 0) {
                throw new IllegalArgumentException("Cantidad inválida para SKU " + sku);
            }
            if (qty <= defaultThreshold) {
                alerts.add(formatAlert(sku, qty, defaultThreshold));
            }
        }
        return alerts;
    }

    private static String formatAlert(String sku, int qty, int threshold) {
        return "LOW_STOCK: sku=" + sku + " qty=" + qty + " threshold=" + threshold;
    }
    
}
