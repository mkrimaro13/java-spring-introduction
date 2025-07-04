package co.com.marimaro.store.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
public class ComprasProducto {
    @EmbeddedId // -> para claves primarias compuestas
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;
    @ManyToOne
    @MapsId(value = "idCompra") // -> permite identificar a compra pertenece un producto
    @JoinColumn(referencedColumnName = "id_compra", insertable = false, updatable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
