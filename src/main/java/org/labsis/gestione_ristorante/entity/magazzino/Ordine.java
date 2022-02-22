package org.labsis.gestione_ristorante.entity.magazzino;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity(name = "Ordine")
@Table(uniqueConstraints = @UniqueConstraint(name = "codice_ordine_unique", columnNames = "codice_ordine"))
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ordine")
    @SequenceGenerator(
            name = "seq_ordine",
            sequenceName = "seq_ordine",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codice_ordine", nullable = false, unique = true, length = 90)
    private String codiceOrdine;

    @Column(name = "data_richiesta", nullable = false)
    private Date dataRichiesta;

    @Column(name = "ordine_evaso")
    private Boolean ordineEvaso;

    @Lob
    @Column(name = "nota")
    private String nota;

    public Ordine() {
        ordineEvaso = false;
    }

    public Ordine(Long id, String codiceOrdine, Date dataRichiesta, Boolean ordineEvaso, String nota) {
        this.id = id;
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
        this.ordineEvaso = ordineEvaso;
        this.nota = nota;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public void setCodiceOrdine(String codiceOrdine) {
        this.codiceOrdine = codiceOrdine;
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
        return Objects.equal(getId(), ordine.getId()) && Objects.equal(getCodiceOrdine(), ordine.getCodiceOrdine()) && Objects.equal(getDataRichiesta(), ordine.getDataRichiesta()) && Objects.equal(getOrdineEvaso(), ordine.getOrdineEvaso()) && Objects.equal(getNota(), ordine.getNota());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getCodiceOrdine(), getDataRichiesta(), getOrdineEvaso(), getNota());
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", codiceOrdine='" + codiceOrdine + '\'' +
                ", dataRichiesta=" + dataRichiesta +
                ", ordineEvaso=" + ordineEvaso +
                ", nota='" + nota + '\'' +
                '}';
    }
}