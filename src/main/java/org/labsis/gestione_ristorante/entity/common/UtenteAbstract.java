package org.labsis.gestione_ristorante.entity.common;

import com.google.common.base.Objects;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.labsis.gestione_ristorante.entity.admin.Account;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@MappedSuperclass
public abstract class UtenteAbstract implements Serializable {

    @Id
    @Column(name = "codice_fiscale", nullable = false, length = 16)
    private String codiceFiscale;

    @Column(name = "nome", nullable = false, length = 90)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 90)
    private String cognome;

    @Column(name = "data_di_nascita")
    private Date dataDiNascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    public abstract Account getAccount();

    public abstract void setAccount(Account account);

    public UtenteAbstract() {
    }

    public UtenteAbstract(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtenteAbstract)) return false;
        UtenteAbstract that = (UtenteAbstract) o;
        return Objects.equal(getCodiceFiscale(), that.getCodiceFiscale()) &&
                Objects.equal(getNome(), that.getNome()) && Objects.equal(getCognome(), that.getCognome())
                        && Objects.equal(getDataDiNascita(), that.getDataDiNascita()) && Objects.equal(getIndirizzo(), that.getIndirizzo())
                        && Objects.equal(getCitta(), that.getCitta());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodiceFiscale(), getNome(), getCognome(), getDataDiNascita(), getIndirizzo(), getCitta());
    }

    @Override
    public String toString() {
        return "Utente{" +
                "codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data di nascita=" + dataDiNascita +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}