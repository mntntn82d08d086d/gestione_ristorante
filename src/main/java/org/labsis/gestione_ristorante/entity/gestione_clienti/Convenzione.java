package org.labsis.gestione_ristorante.entity.gestione_clienti;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Convenzione implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_convenzione")
    @SequenceGenerator(
            name = "seq_convenzione",
            sequenceName = "seq_convenzione",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codice_convenzione", nullable = false, length = 15)
    private String codiceConvenzione;

    @Column(name = "sconto", nullable = false)
    private Double sconto;

    @Column(name = "data_stipula", nullable = false)
    private Date dataStipula;

}