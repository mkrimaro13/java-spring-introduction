package co.com.marimaro.store.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "categoria") // nombre del atributo en la clase Producto
    private List<Producto> productos;

}
