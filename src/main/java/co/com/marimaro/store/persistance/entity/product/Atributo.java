package co.com.marimaro.store.persistance.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "atributos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atributo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "atributo", fetch = FetchType.LAZY)
    private List<ValoresAtributos> valoresAtributos;
}
