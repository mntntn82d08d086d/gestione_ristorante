package org.labsis.gestione_ristorante.entity.admin;

import lombok.*;
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
public class Socio extends UtenteAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_socio")
    @SequenceGenerator(
            name = "seq_socio",
            sequenceName = "seq_socio",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

/*
    @OneToMany(mappedBy = "socio", orphanRemoval = true)
    private Set<R_OS> r_os = new LinkedHashSet<>();
*/

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account = new Account();

    public Socio(String codiceFiscale, String nome, String cognome,
                 Date dataDiNascita, String indirizzo, String citta, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.account = account;
    }
}