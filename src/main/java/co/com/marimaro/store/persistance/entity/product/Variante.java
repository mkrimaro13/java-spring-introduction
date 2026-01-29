package co.com.marimaro.store.persistance.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(schema = "comercial", name = "variantes_productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Variante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false, updatable = false)
    private Producto producto;
    private String sku;
    private Double precio;
    private Integer descuento;
    @Column(name = "unidades_disponibles")
    private Integer stock;
    @Column(name = "enlace_imagen")
    private String imagenUrl;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "comercial",
            name = "valores_variantes",
            joinColumns = @JoinColumn(name = "id_variante"),
            inverseJoinColumns = @JoinColumn(name = "id_valor_atributo")
    )
    private List<ValoresAtributos> valoresAtributos;
}
