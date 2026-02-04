package co.com.marimaro.store.persistance.repository.Producto;

public record ProductoFilters(
        int page_number,
        int page_size,
        String nombre,
        Long idCategoria,
        String talla,
        String material,
        String color,
        String sku) {

}
