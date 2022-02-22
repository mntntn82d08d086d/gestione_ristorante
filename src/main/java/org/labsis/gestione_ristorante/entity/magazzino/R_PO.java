package org.labsis.gestione_ristorante.entity.magazzino;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
public class R_PO implements Serializable {

    @EmbeddedId
    private R_POKey id;

    @MapsId("prodottoId")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    @MapsId("ordineId")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;

    @Column(name = "quantita", nullable = false)
    private Double quantita;

    public R_PO() {
    }

    public R_PO(R_POKey id, Prodotto prodotto, Ordine ordine, Double quantita) {
        this.id = id;
        this.prodotto = prodotto;
        this.ordine = ordine;
        this.quantita = quantita;
    }

    @Transient
    public Long getProdottoId() {
        return id.getProdottoId();
    }

    @Transient
    public Long getOrdineId() {
        return id.getOrdineId();
    }

    public R_POKey getId() {
        return id;
    }

    public void setId(R_POKey id) {
        this.id = id;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Double getQuantita() {
        return quantita;
    }

    public void setQuantita(Double quantita) {
        this.quantita = quantita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_PO)) return false;
        R_PO r_po = (R_PO) o;
        return Objects.equal(getId(), r_po.getId()) && Objects.equal(getProdotto(), r_po.getProdotto()) && Objects.equal(getOrdine(), r_po.getOrdine()) && Objects.equal(getQuantita(), r_po.getQuantita());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getProdotto(), getOrdine(), getQuantita());
    }

    @Override
    public String toString() {
        return "R_PO{" +
                "id=" + id +
                ", prodotto=" + prodotto +
                ", ordine=" + ordine +
                ", quantita=" + quantita +
                '}';
    }
}
