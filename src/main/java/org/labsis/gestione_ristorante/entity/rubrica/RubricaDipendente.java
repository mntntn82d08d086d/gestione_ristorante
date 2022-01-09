package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaDipendente implements Serializable {

    @EmbeddedId
    private RubricaDipendenteKey id;

    @MapsId("contattoId")
    @ManyToOne
    @JoinColumn(name = "contatto_id")
    private Contatto contatto;

    @MapsId("dipendenteId")
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

}
