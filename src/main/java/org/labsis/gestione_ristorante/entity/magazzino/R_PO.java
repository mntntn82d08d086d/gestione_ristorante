package org.labsis.gestione_ristorante.entity.magazzino;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R_PO implements Serializable {

    @EmbeddedId
    private R_POKey id;

    @MapsId("prodottoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    @MapsId("ordineId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;

    @Column(name = "quantita", nullable = false)
    private Double quantita;

    @Transient
    public Long getProdottoId() {
        return id.getProdottoId();
    }

    @Transient
    public Long getOrdineId() {
        return id.getOrdineId();
    }
}
