package org.labsis.gestione_ristorante.entity.admin;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.common.Utente;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * TODO: Documentazione
 */

@Entity(name = "Socio")
public class Socio extends Utente implements Serializable {

/*
    @OneToMany(mappedBy = "socio", orphanRemoval = true)
    private Set<R_OS> r_os = new LinkedHashSet<>();
*/

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Socio() {
        super();
        this.account = new Account();
    }

    public Socio(String codiceFiscale, String nome, String cognome,
                 Date dataDiNascita, String indirizzo, String citta, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.account = account;
    }

    public Socio(Long id, String codiceFiscale, String nome, String cognome,
                 Date dataDiNascita, String indirizzo, String citta, Account account) {
        super(id, codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.account = account;
    }

    public Socio(Long id, String codiceFiscale, String nome, String cognome,
                 Date dataDiNascita, String indirizzo, String citta, Account account, List<Contatto> contatti) {
        super(id, codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta, contatti);
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
        return getAccount().equals(socio.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAccount());
    }

    @Override
    public String toString() {
        return "Socio{" +
                super.toString() +
                ", account=" + account +
                '}';
    }
}