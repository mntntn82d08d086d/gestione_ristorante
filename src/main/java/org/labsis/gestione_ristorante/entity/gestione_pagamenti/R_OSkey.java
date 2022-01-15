package org.labsis.gestione_ristorante.entity.gestione_pagamenti;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Embeddable
public class R_OSkey implements Serializable {

    @Column(name = "ordine_id", nullable = false)
    private Long ordineId;

    @Column(name = "socio_id", nullable = false)
    private String socioPiva;

    public R_OSkey() {
    }

    public R_OSkey(Long ordineId, String socioPiva) {
        this.ordineId = ordineId;
        this.socioPiva = socioPiva;
    }

    public Long getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(Long ordineId) {
        this.ordineId = ordineId;
    }

    public String getSocioPiva() {
        return socioPiva;
    }

    public void setSocioPiva(String socioId) {
        this.socioPiva = socioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_OSkey)) return false;
        R_OSkey r_oSkey = (R_OSkey) o;
        return Objects.equal(getOrdineId(), r_oSkey.getOrdineId()) && Objects.equal(getSocioPiva(), r_oSkey.getSocioPiva());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOrdineId(), getSocioPiva());
    }

    @Override
    public String toString() {
        return "R_OSkey{" +
                "ordineId=" + ordineId +
                ", socioId=" + socioPiva +
                '}';
    }
}