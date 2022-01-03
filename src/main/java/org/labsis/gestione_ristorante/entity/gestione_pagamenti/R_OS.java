package org.labsis.gestione_ristorante.entity.gestione_pagamenti;

import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.entity.magazzino.Ordine;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity(name = "R_OS")
@Table(name = "r_os")
public class R_OS implements Serializable {

    @EmbeddedId
    private R_OSkey id;

    @MapsId("ordineId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;

    @MapsId("socioId")
    @JoinColumn(name = "socio_id", nullable = false)
    @ManyToOne(optional = false)
    private Socio socio;

    @Column(name = "data_evasione", nullable = false)
    private Date dataEvasione;

    public R_OS() {
    }

    public R_OS(R_OSkey id, Ordine ordine, Socio socio, Date dataEvasione) {
        this.id = id;
        this.ordine = ordine;
        this.socio = socio;
        this.dataEvasione = dataEvasione;
    }

    public R_OSkey getId() {
        return id;
    }

    public void setId(R_OSkey id) {
        this.id = id;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Date getDataEvasione() {
        return dataEvasione;
    }

    public void setDataEvasione(Date dataEvasione) {
        this.dataEvasione = dataEvasione;
    }

    @Transient
    public Long getOrdineId() {
        return id.getOrdineId();
    }

    @Transient
    public Long getSocioId() {
        return id.getSocioId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_OS)) return false;

        R_OS r_os = (R_OS) o;

        if (!getId().equals(r_os.getId())) return false;
        if (!getOrdine().equals(r_os.getOrdine())) return false;
        if (!getSocio().equals(r_os.getSocio())) return false;
        return getDataEvasione().equals(r_os.getDataEvasione());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getOrdine().hashCode();
        result = 31 * result + getSocio().hashCode();
        result = 31 * result + getDataEvasione().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "R_OS{" +
                "id=" + id +
                ", ordine=" + ordine +
                ", socio=" + socio +
                ", dataEvasione=" + dataEvasione +
                '}';
    }
}