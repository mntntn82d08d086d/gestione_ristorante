package org.labsis.gestione_ristorante.entity.common;

import com.google.common.base.Objects;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * TODO: Documentazione
 */

@MappedSuperclass
public abstract class AziendaAbstract implements Azienda {

    @Id
    @Column(name = "piva", length = 21, nullable = false)
    private String piva;

    @Column(name = "nome_azienda", nullable = false)
    private String nomeAzienda;

    @Column(name = "sede_legale", nullable = false)
    private String sedeLegale;

    @Column(name = "citta", nullable = false)
    private String citta;

    public AziendaAbstract() {
    }

    public AziendaAbstract(String piva, String nomeAzienda, String sedeLegale, String citta) {
        this.piva = piva;
        this.nomeAzienda = nomeAzienda;
        this.sedeLegale = sedeLegale;
        this.citta = citta;
    }

    public abstract Set<Contatto> getContatti();

    public abstract void setContatti(Set<Contatto> contatti);

    @Transient
    public abstract void addContatto(Contatto contatto);

    @Transient
    public abstract void removeContattoByTipologia(String tipologia);

    @Transient
    public abstract void removeContattoByTipologiaAndSuffix(String tipologia, String suffix);

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
        if (!(o instanceof AziendaAbstract)) return false;
        AziendaAbstract that = (AziendaAbstract) o;
        return Objects.equal(getPiva(), that.getPiva()) && Objects.equal(getNomeAzienda(), that.getNomeAzienda()) && Objects.equal(getSedeLegale(), that.getSedeLegale()) && Objects.equal(getCitta(), that.getCitta());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPiva(), getNomeAzienda(), getSedeLegale(), getCitta());
    }

    @Override
    public String toString() {
        return "Azienda{" +
                "piva='" + piva + '\'' +
                ", nomeAzienda='" + nomeAzienda + '\'' +
                ", sedeLegale='" + sedeLegale + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
