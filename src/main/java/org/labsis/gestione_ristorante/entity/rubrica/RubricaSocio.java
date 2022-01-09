package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;
import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.entity.common.Contatto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaSocio implements Serializable {

    @EmbeddedId
    private RubricaSocioKey id;

    @MapsId("contattoId")
    @ManyToOne
    @JoinColumn(name = "contatto_id")
    private Contatto contatto;

    @MapsId("socioId")
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

}
