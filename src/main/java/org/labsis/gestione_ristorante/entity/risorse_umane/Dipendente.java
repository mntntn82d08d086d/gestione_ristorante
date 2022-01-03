package org.labsis.gestione_ristorante.entity.risorse_umane;

import org.labsis.gestione_ristorante.entity.admin.Account;
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

@Entity(name = "Dipendente")
public class Dipendente extends Utente implements Serializable {

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

    public Dipendente() {
    }

    public Dipendente(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, Integer ferieDaContratto, Integer permessiDaContratto, Mansione mansione, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.ferieDaContratto = ferieDaContratto;
        this.permessiDaContratto = permessiDaContratto;
        this.mansione = mansione;
        this.account = account;
    }

    public Dipendente(Long id, String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, Integer ferieDaContratto, Integer permessiDaContratto, Mansione mansione, Account account) {
        super(id, codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.ferieDaContratto = ferieDaContratto;
        this.permessiDaContratto = permessiDaContratto;
        this.mansione = mansione;
        this.account = account;
    }

    public Dipendente(Long id, String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, List<Contatto> contatti, Integer ferieDaContratto, Integer permessiDaContratto, Mansione mansione, Account account) {
        super(id, codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta, contatti);
        this.ferieDaContratto = ferieDaContratto;
        this.permessiDaContratto = permessiDaContratto;
        this.mansione = mansione;
        this.account = account;
    }

    public Integer getFerieDaContratto() {
        return ferieDaContratto;
    }

    public void setFerieDaContratto(Integer ferieDaContratto) {
        this.ferieDaContratto = ferieDaContratto;
    }

    public Integer getPermessiDaContratto() {
        return permessiDaContratto;
    }

    public void setPermessiDaContratto(Integer permessiDaContratto) {
        this.permessiDaContratto = permessiDaContratto;
    }

    public Mansione getMansione() {
        return mansione;
    }

    public void setMansione(Mansione mansione) {
        this.mansione = mansione;
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
        if (!(o instanceof Dipendente)) return false;
        if (!super.equals(o)) return false;
        Dipendente that = (Dipendente) o;
        return Objects.equals(getFerieDaContratto(), that.getFerieDaContratto()) && Objects.equals(getPermessiDaContratto(), that.getPermessiDaContratto()) && getMansione() == that.getMansione() && getAccount().equals(that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFerieDaContratto(), getPermessiDaContratto(), getMansione(), getAccount());
    }

    @Override
    public String toString() {
        return "Dipendenti{" +
                super.toString() +
                ", ferieDaContratto=" + ferieDaContratto +
                ", permessiDaContratto=" + permessiDaContratto +
                ", mansione=" + mansione +
                ", account=" + account +
                '}';
    }

    public enum Mansione {
        NS("Non Specificato"), MAGAZZINIERE("Magazziniere"), CASSIERE("Cassiere"), CAMERIERE("Cameriere");

        Mansione(String mansione) {
            this.mansione = mansione;
        }
        private String mansione;
    }
}
