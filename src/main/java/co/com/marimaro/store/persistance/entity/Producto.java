package co.com.marimaro.store.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Producto {
    // Indica que es la clave primaria simple de la tabla
    @Id
    // Indica que la clave primaria se genera automáticamente, y se indica que su forma de generación automática es
    // identididad (valor que se crea automáticamente de manera secuencial)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    private String nombre;
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private Double precio;
    @Column(name = "cantidad_stock")
    private Integer stock;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;
}
