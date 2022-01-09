package org.labsis.gestione_ristorante.entity.risorse_umane;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermessiDipendentiKey implements Serializable {

    @Column(name = "data_permesso", nullable = false)
    private Date dataPermesso;

    @Column(name = "dipendente_id", nullable = false)
    private Long dipendenteId;

}