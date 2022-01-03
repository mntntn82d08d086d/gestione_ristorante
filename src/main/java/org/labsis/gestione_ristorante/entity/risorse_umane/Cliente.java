package org.labsis.gestione_ristorante.entity.risorse_umane;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.common.Utente;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * TODO: Documentazione
 */

@Entity(name = "Cliente")
public class Cliente extends Utente implements Serializable {

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;

    public Cliente() {
        super();
        this.account = new Account();
    }

    public Cliente(Long id, String codiceFiscale, String nome, String cognome,
                   Date dataDiNascita, String indirizzo, String citta, Account account) {
        super(id, codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
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
        if (!(o instanceof Cliente)) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return getAccount().equals(cliente.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAccount());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                ", account=" + account +
                '}';
    }
}