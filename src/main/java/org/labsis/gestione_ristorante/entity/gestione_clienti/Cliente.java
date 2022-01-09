package org.labsis.gestione_ristorante.entity.gestione_clienti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.common.UtenteAbstract;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends UtenteAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    @SequenceGenerator(
            name = "seq_cliente",
            sequenceName = "seq_cliente",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account = new Account();

    public Cliente(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
    }
}