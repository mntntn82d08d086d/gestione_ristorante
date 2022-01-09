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
public class R_FP implements Serializable {

    @EmbeddedId
    private R_FPKey id;

    @MapsId("fornitoreId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "fornitore_id", nullable = false)
    private Fornitore fornitore;

    @MapsId("prodottoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    @Column(name = "prezzo_unitario", nullable = false)
    private Double prezzoUnitario;

    @Column(name = "tempo_consegna", nullable = false)
    private Integer tempoConsegna;

    @Transient
    public Long getFornitoreId() {
        return id.getFornitoreId();
    }

    @Transient
    public Long getProdottoId() {
        return id.getProdottoId();
    }

}