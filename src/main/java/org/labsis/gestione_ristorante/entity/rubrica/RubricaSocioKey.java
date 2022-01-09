package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaSocioKey implements Serializable {

    @Column(name = "contatto_id")
    private Long contattoId;

    @Column(name = "socio_id")
    private Long socioId;

}
