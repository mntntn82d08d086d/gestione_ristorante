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
public class R_FPKey implements Serializable {

    @Column(name = "fornitore_id", nullable = false)
    private Long fornitoreId;

    @Column(name = "prodotto_id", nullable = false)
    private Long prodottoId;

}
