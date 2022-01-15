package org.labsis.gestione_ristorante.entity.magazzino;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
public class R_FP implements Serializable {

    @EmbeddedId
    private R_FPKey id;

    @MapsId("fornitorePiva")
    @ManyToOne(optional = false)
    @JoinColumn(name = "fornitore_piva", nullable = false)
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

    @Transient
    public String getFornitoreId() {
        return id.getFornitorePiva();
    }

    @Transient
    public Long getProdottoId() {
        return id.getProdottoId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_FP)) return false;
        R_FP r_fp = (R_FP) o;
        return Objects.equal(getId(), r_fp.getId()) && Objects.equal(getFornitore(), r_fp.getFornitore()) && Objects.equal(getProdotto(), r_fp.getProdotto()) && Objects.equal(getPrezzoUnitario(), r_fp.getPrezzoUnitario()) && Objects.equal(getTempoConsegna(), r_fp.getTempoConsegna());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getFornitore(), getProdotto(), getPrezzoUnitario(), getTempoConsegna());
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