package org.labsis.gestione_ristorante.entity.risorse_umane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.common.UtenteAbstract;

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
public class Dipendente extends UtenteAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dipendente")
    @SequenceGenerator(
            name = "seq_dipendente",
            sequenceName = "seq_dipendente",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ferie_da_contratto", nullable = false)
    private Integer ferieDaContratto;

    @Column(name = "permessi_da_contratto", nullable = false)
    private Integer permessiDaContratto;

    @Enumerated(EnumType.STRING)
    @Column(name = "mansione", nullable = false)
    private Mansione mansione = Mansione.NS;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account = new Account();

    public Dipendente(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, Integer ferieDaContratto, Integer permessiDaContratto, Mansione mansione, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.ferieDaContratto = ferieDaContratto;
        this.permessiDaContratto = permessiDaContratto;
        this.mansione = mansione;
        this.account = account;
    }

    public enum Mansione {
        NS("Non Specificato"), MAGAZZINIERE("Magazziniere"), CASSIERE("Cassiere"), CAMERIERE("Cameriere");

        Mansione(String mansione) {
            this.mansione = mansione;
        }
        private String mansione;
    }
}
