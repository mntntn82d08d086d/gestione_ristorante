package org.labsis.gestione_ristorante.entity.gestione_clienti;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity
public class Convenzione implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_convenzione")
    @SequenceGenerator(
            name = "seq_convenzione",
            sequenceName = "seq_convenzione",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codice_convenzione", nullable = false, length = 15)
    private String codiceConvenzione;

    @Column(name = "sconto", nullable = false)
    private Double sconto;

    @Column(name = "data_stipula", nullable = false)
    private Date dataStipula;

    public Convenzione() {
    }

    public Convenzione(Long id, String codiceConvenzione, Double sconto, Date dataStipula) {
        this.id = id;
        this.codiceConvenzione = codiceConvenzione;
        this.sconto = sconto;
        this.dataStipula = dataStipula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodiceConvenzione() {
        return codiceConvenzione;
    }

    public void setCodiceConvenzione(String codiceConvenzione) {
        this.codiceConvenzione = codiceConvenzione;
    }

    public Double getSconto() {
        return sconto;
    }

    public void setSconto(Double sconto) {
        this.sconto = sconto;
    }

    public Date getDataStipula() {
        return dataStipula;
    }

    public void setDataStipula(Date dataStipula) {
        this.dataStipula = dataStipula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convenzione)) return false;
        Convenzione that = (Convenzione) o;
        return Objects.equal(getId(), that.getId()) && Objects.equal(getCodiceConvenzione(), that.getCodiceConvenzione()) && Objects.equal(getSconto(), that.getSconto()) && Objects.equal(getDataStipula(), that.getDataStipula());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getCodiceConvenzione(), getSconto(), getDataStipula());
    }

    @Override
    public String toString() {
        return "Convenzione{" +
                "id=" + id +
                ", codiceConvenzione='" + codiceConvenzione + '\'' +
                ", sconto=" + sconto +
                ", dataStipula=" + dataStipula +
                '}';
    }
}