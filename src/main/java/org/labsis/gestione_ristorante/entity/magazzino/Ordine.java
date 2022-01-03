package org.labsis.gestione_ristorante.entity.magazzino;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity(name = "Ordine")
@Table(name = "ordine")
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codice_ordine", nullable = false, unique = true, length = 90)
    private String codiceOrdine;

    @Column(name = "data_richiesta", nullable = false)
    private Date dataRichiesta;

    @Column(name = "ordine_evaso")
    private Boolean ordineEvaso = false;

    @Lob
    @Column(name = "nota")
    private String nota = "";

/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ordine")
    @ToString.Exclude
    private Set<R_PO> r_po = new java.util.LinkedHashSet<>();

    @OneToMany
    private Set<R_OS> r_os;
*/

    public Ordine() {
    }

    public Ordine(String codiceOrdine, Date dataRichiesta, Boolean ordineEvaso, String nota) {
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
        this.ordineEvaso = ordineEvaso;
        this.nota = nota;
    }

    public Ordine(String codiceOrdine, Date dataRichiesta, String nota) {
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
        this.nota = nota;
    }

    public Ordine(String codiceOrdine, Date dataRichiesta) {
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
    }

/*
    @Transient
    public void addRpo(R_PO r) {
        r_po.add(r);
    }

    @Transient
    public void removeRpo(R_PO r) {
        r_po.remove(r);
    }
*/

    public Ordine(Long id, String codiceOrdine, Date dataRichiesta, Boolean ordineEvaso, String nota) {
        this.id = id;
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
        this.ordineEvaso = ordineEvaso;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public void setCodiceOrdine(String codice_ordine) {
        this.codiceOrdine = codice_ordine;
    }

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public Boolean getOrdineEvaso() {
        return ordineEvaso;
    }

    public void setOrdineEvaso(Boolean ordineEvaso) {
        this.ordineEvaso = ordineEvaso;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ordine)) return false;

        Ordine ordine = (Ordine) o;

        if (!getId().equals(ordine.getId())) return false;
        if (!getCodiceOrdine().equals(ordine.getCodiceOrdine())) return false;
        if (!getDataRichiesta().equals(ordine.getDataRichiesta())) return false;
        if (!getOrdineEvaso().equals(ordine.getOrdineEvaso())) return false;
        return getNota() != null ? getNota().equals(ordine.getNota()) : ordine.getNota() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 3 * result + getCodiceOrdine().hashCode();
        result = 5 * result + getDataRichiesta().hashCode();
        result = 7 * result + getOrdineEvaso().hashCode();
        result = 11 * result + (getNota() != null ? getNota().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", codice_ordine='" + codiceOrdine + '\'' +
                ", dataRichiesta=" + dataRichiesta +
                ", ordineEvaso=" + ordineEvaso +
                ", nota='" + nota + '\'' +
                '}';
    }
}