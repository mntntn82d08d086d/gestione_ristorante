package org.labsis.gestione_ristorante.entity.common;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * TODO: Documentazione
 */

@MappedSuperclass
public abstract class Azienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "piva", length = 21, nullable = false)
    private String piva;

    @Column(name = "nome_azienda", nullable = false)
    private String nomeAzienda;

    @Column(name = "sede_legale", nullable = false)
    private String sedeLegale;

    @Column(name = "citta", nullable = false)
    private String citta;

    public Azienda() {
    }

    public Azienda(String piva, String nomeAzienda, String sedeLegale, String citta) {
        this.piva = piva;
        this.nomeAzienda = nomeAzienda;
        this.sedeLegale = sedeLegale;
        this.citta = citta;
    }

    public Azienda(Long id, String piva, String nomeAzienda, String sedeLegale, String citta) {
        this.id = id;
        this.piva = piva;
        this.nomeAzienda = nomeAzienda;
        this.sedeLegale = sedeLegale;
        this.citta = citta;
    }

    @Transient
    public abstract List<Contatto> getContatti();

    @Transient
    public abstract void setContatti(List<Contatto> contatti);

    @Transient
    public abstract void addContatto(Contatto contatto);

    @Transient
    public abstract void removeContattoByTipologia(String tipologia);

    @Transient
    public abstract void removeContattoByTipologiaAndSuffix(String tipologia, String suffix);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
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
        if (!(o instanceof Azienda)) return false;

        Azienda azienda = (Azienda) o;

        if (!getId().equals(azienda.getId())) return false;
        if (!getPiva().equals(azienda.getPiva())) return false;
        if (!getNomeAzienda().equals(azienda.getNomeAzienda())) return false;
        if (!getSedeLegale().equals(azienda.getSedeLegale())) return false;
        return getCitta().equals(azienda.getCitta());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 3 * result + getPiva().hashCode();
        result = 5 * result + getNomeAzienda().hashCode();
        result = 7 * result + getSedeLegale().hashCode();
        result = 11 * result + getCitta().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Azienda{" +
                "id=" + id +
                ", piva='" + piva + '\'' +
                ", nomeAzienda='" + nomeAzienda + '\'' +
                ", sedeLegale='" + sedeLegale + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
