package co.com.marimaro.store.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ComprasProductoPK implements Serializable {
    @Column(name = "id_compra")
    private Long idCompra;
    @Column(name = "id_producto")
    private Long idProducto;
}
