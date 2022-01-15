package org.labsis.gestione_ristorante.entity.admin;

import com.google.common.base.Objects;
import lombok.*;
import org.labsis.gestione_ristorante.entity.common.Utente;
import org.labsis.gestione_ristorante.entity.common.UtenteAbstract;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

/**
 * TODO: Documentazione
 */

@Entity
public class Socio extends UtenteAbstract implements Utente {

    @OneToOne(optional = false, orphanRemoval = true)
    private Account account;

    public Socio() {
        super();
        this.account = new Account();
    }

    public Socio(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.account = account;
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
        if (!(o instanceof Socio)) return false;
        if (!super.equals(o)) return false;
        Socio socio = (Socio) o;
        return Objects.equal(getAccount(), socio.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getAccount());
    }

    @Override
    public String toString() {
        return "Socio{" +
                super.toString() +
                ", account=" + account +
                '}';
    }
}