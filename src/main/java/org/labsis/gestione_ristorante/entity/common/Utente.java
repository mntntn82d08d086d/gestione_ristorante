package org.labsis.gestione_ristorante.entity.common;

import org.labsis.gestione_ristorante.entity.admin.Account;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: Documentazione
 */

@MappedSuperclass
public abstract class Utente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @OneToMany(fetch = javax.persistence.FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contatto> contatti = new LinkedList<>();

    public Utente() {
    }

    public Utente(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public Utente(Long id, String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta) {
        this.id = id;
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public Utente(Long id, String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, List<Contatto> contatti) {
        this.id = id;
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.contatti = contatti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Contatto> getContatti() {
        return contatti;
    }

    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti;
    }

    public abstract Account getAccount();

    public abstract void setAccount(Account account);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utente)) return false;

        Utente utente = (Utente) o;

        if (!getId().equals(utente.getId())) return false;
        if (!getCodiceFiscale().equals(utente.getCodiceFiscale())) return false;
        if (!getNome().equals(utente.getNome())) return false;
        if (!getCognome().equals(utente.getCognome())) return false;
        if (getDataDiNascita() != null ? !getDataDiNascita().equals(utente.getDataDiNascita()) : utente.getDataDiNascita() != null)
            return false;
        if (getIndirizzo() != null ? !getIndirizzo().equals(utente.getIndirizzo()) : utente.getIndirizzo() != null)
            return false;
        if (getCitta() != null ? !getCitta().equals(utente.getCitta()) : utente.getCitta() != null) return false;
        return getContatti() != null ? getContatti().equals(utente.getContatti()) : utente.getContatti() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCodiceFiscale().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getCognome().hashCode();
        result = 31 * result + (getDataDiNascita() != null ? getDataDiNascita().hashCode() : 0);
        result = 31 * result + (getIndirizzo() != null ? getIndirizzo().hashCode() : 0);
        result = 31 * result + (getCitta() != null ? getCitta().hashCode() : 0);
        result = 31 * result + (getContatti() != null ? getContatti().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                ", contatti=" + contatti +
                '}';
    }
}