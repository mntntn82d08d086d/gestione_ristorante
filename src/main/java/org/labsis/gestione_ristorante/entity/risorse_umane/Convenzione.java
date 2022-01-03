package org.labsis.gestione_ristorante.entity.risorse_umane;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity(name = "Convenzione")
public class Convenzione implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

        if (!getId().equals(that.getId())) return false;
        if (!getCodiceConvenzione().equals(that.getCodiceConvenzione())) return false;
        if (!getSconto().equals(that.getSconto())) return false;
        return getDataStipula().equals(that.getDataStipula());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 3 * result + getCodiceConvenzione().hashCode();
        result = 5 * result + getSconto().hashCode();
        result = 7 * result + getDataStipula().hashCode();
        return result;
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