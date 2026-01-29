package co.com.marimaro.store.persistance.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(schema = "comercial", name = "valores_atributos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValoresAtributos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atributo", insertable = false, updatable = false)
    private Atributo atributo;
    private String valor;
    @ManyToMany(mappedBy = "valoresAtributos", fetch = FetchType.LAZY)
    private List<Variante> variantes;
}
