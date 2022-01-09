package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaFornitoreKey implements Serializable {

    @Column(name = "contatto_id")
    private Long contatto_id;

    @Column(name = "fornitore_id")
    private Long fornitore_id;

}
