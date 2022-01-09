package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaFornitore implements Serializable {

    @EmbeddedId
    private RubricaFornitoreKey rubricaFornitoreKey;

    @MapsId("contatto_id")
    @ManyToOne
    @JoinColumn(name = "contatto_id")
    private Contatto contatto;

    @MapsId("fornitore_id")
    @ManyToOne
    @JoinColumn(name = "fornitore_id")
    private Fornitore fornitore;

}