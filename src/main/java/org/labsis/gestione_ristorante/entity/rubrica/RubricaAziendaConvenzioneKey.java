package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaAziendaConvenzioneKey implements Serializable {

    @Column(name = "contatto_id")
    private Long contattoId;

    @Column(name = "azienda_convenzione_id")
    private Long aziendaConvenzioneId;

}
