package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaAziendaConvenzione implements Serializable {

    @EmbeddedId
    private RubricaAziendaConvenzioneKey id;

    @MapsId("contatto_id")
    @ManyToOne
    @JoinColumn(name = "contatto_id")
    private Contatto contatto;

    @MapsId("aziendaConvenzioneId")
    @ManyToOne
    @JoinColumn(name = "azienda_convenzione_id")
    private AziendaConvenzione aziendaConvenzione;

}
