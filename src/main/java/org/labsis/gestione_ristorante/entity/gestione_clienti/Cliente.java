package org.labsis.gestione_ristorante.entity.gestione_clienti;

import com.google.common.base.Objects;
import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.common.Utente;
import org.labsis.gestione_ristorante.entity.common.UtenteAbstract;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

/**
 * TODO: Documentazione
 */

@Entity
public class Cliente extends UtenteAbstract implements Utente {

    @OneToMany
    @JoinTable(
            name = "rubrica_cliente",
            joinColumns = @JoinColumn(name = "cliente_codice_fiscale", referencedColumnName = "codice_fiscale",
                    foreignKey = @ForeignKey(name = "c_cod_fis_fk")),
            inverseJoinColumns = @JoinColumn(name = "contatto_id",
                    foreignKey = @ForeignKey(name = "c_contatto_id_fk")),
            uniqueConstraints = @UniqueConstraint(name = "c_contatto_id_unique", columnNames = "contatto_id"),
            indexes = @Index(name = "c_cod_fis_idx", columnList = "cliente_codice_fiscale")
    )
    private Set<Contatto> contatti;

    @OneToOne(optional = false, orphanRemoval = true)
    private Account account;

    public Cliente() {
        super();
        account = new Account();
        contatti = new LinkedHashSet<>();
    }

    public Cliente(String codiceFiscale, String nome, String cognome, Date dataDiNascita,
                                String indirizzo, String citta, Account account, Set<Contatto> contatti) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.account = account;
        this.contatti = contatti;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equal(getAccount(), cliente.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getAccount());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", " + super.toString() +
                ", account=" + account +
                '}';
    }
}