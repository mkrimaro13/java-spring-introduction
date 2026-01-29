package co.com.marimaro.store.persistance.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(schema = "comercial", name = "categorias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean activo;
    @ManyToMany(mappedBy = "categorias",fetch = FetchType.LAZY)
    private List<Producto> productos;
}
