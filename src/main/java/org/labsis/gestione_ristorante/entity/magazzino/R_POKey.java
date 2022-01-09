package org.labsis.gestione_ristorante.entity.magazzino;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R_POKey implements Serializable {

    @Column(name = "prodotto_id")
    protected Long prodottoId;

    @Column(name = "ordine_id")
    protected Long ordineId;

}