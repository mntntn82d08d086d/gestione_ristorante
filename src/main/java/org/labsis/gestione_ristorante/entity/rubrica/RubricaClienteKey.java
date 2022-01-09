package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaClienteKey implements Serializable {

    @Column(name = "contatto_id")
    private Long contattoId;

    @Column(name = "cliente_id")
    private Long clienteId;

}
