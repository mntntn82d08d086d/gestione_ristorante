package org.labsis.gestione_ristorante.entity.magazzino;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity(name = "R_PO")
public class R_PO implements Serializable {

    @EmbeddedId
    private R_POKey id;

    @MapsId("prodottoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;

    @MapsId("ordineId")
    @ManyToOne(optional = false)
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

    @Transient
    public Long getProdottoId() {
        return id.getProdottoId();
    }

    @Transient
    public Long getOrdineId() {
        return id.getOrdineId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_PO)) return false;

        R_PO r_po = (R_PO) o;

        if (!getId().equals(r_po.getId())) return false;
        if (!getProdotto().equals(r_po.getProdotto())) return false;
        if (!getOrdine().equals(r_po.getOrdine())) return false;
        return getQuantita().equals(r_po.getQuantita());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getProdotto().hashCode();
        result = 31 * result + getOrdine().hashCode();
        result = 31 * result + getQuantita().hashCode();
        return result;
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
