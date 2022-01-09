package org.labsis.gestione_ristorante.entity.rubrica;

import lombok.*;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.gestione_clienti.Cliente;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaCliente implements Serializable {

    @EmbeddedId
    private RubricaClienteKey id;

    @MapsId("contattoId")
    @ManyToOne
    @JoinColumn(name = "contatto_id")
    private Contatto contatto;

    @MapsId("clienteId")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
