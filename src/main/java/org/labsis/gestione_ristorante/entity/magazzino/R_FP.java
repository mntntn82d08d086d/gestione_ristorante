package org.labsis.gestione_ristorante.entity.magazzino;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity(name = "R_FP")
@Table(name = "r_fp")
public class R_FP implements Serializable {

    @EmbeddedId
    private R_FPKey id;

    @MapsId("fornitoreId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "fornitore_id", nullable = false)
    private Fornitore fornitore;

    @MapsId("prodottoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    @Column(name = "prezzo_unitario", nullable = false)
    private Double prezzoUnitario;

    @Column(name = "tempo_consegna", nullable = false)
    private Integer tempoConsegna;

    public R_FP() {
    }

    public R_FP(R_FPKey id, Fornitore fornitore, Prodotto prodotto, Double prezzoUnitario, Integer tempoConsegna) {
        this.id = id;
        this.fornitore = fornitore;
        this.prodotto = prodotto;
        this.prezzoUnitario = prezzoUnitario;
        this.tempoConsegna = tempoConsegna;
    }

    public R_FPKey getId() {
        return id;
    }

    public void setId(R_FPKey id) {
        this.id = id;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(Double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public Integer getTempoConsegna() {
        return tempoConsegna;
    }

    public void setTempoConsegna(Integer tempoConsegna) {
        this.tempoConsegna = tempoConsegna;
    }

    @Transient
    public Long getFornitoreId() {
        return id.getFornitoreId();
    }

    @Transient
    public Long getProdottoId() {
        return id.getProdottoId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_FP)) return false;

        R_FP r_fp = (R_FP) o;

        if (!getId().equals(r_fp.getId())) return false;
        if (!getFornitore().equals(r_fp.getFornitore())) return false;
        if (!getProdotto().equals(r_fp.getProdotto())) return false;
        if (!getPrezzoUnitario().equals(r_fp.getPrezzoUnitario())) return false;
        return getTempoConsegna().equals(r_fp.getTempoConsegna());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFornitore().hashCode();
        result = 31 * result + getProdotto().hashCode();
        result = 31 * result + getPrezzoUnitario().hashCode();
        result = 31 * result + getTempoConsegna().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "R_FP{" +
                "id=" + id +
                ", fornitore=" + fornitore +
                ", prodotto=" + prodotto +
                ", prezzoUnitario=" + prezzoUnitario +
                ", tempoConsegna=" + tempoConsegna +
                '}';
    }
}