package org.labsis.gestione_ristorante.entity.gestione_pagamenti;

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
    private Long socioId;

    public R_OSkey() {
    }

    public R_OSkey(Long ordineId, Long socioId) {
        this.ordineId = ordineId;
        this.socioId = socioId;
    }

    public Long getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(Long ordineId) {
        this.ordineId = ordineId;
    }

    public Long getSocioId() {
        return socioId;
    }

    public void setSocioId(Long socioId) {
        this.socioId = socioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R_OSkey)) return false;

        R_OSkey r_oSkey = (R_OSkey) o;

        if (!getOrdineId().equals(r_oSkey.getOrdineId())) return false;
        return getSocioId().equals(r_oSkey.getSocioId());
    }

    @Override
    public int hashCode() {
        int result = getOrdineId().hashCode();
        result = 31 * result + getSocioId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "R_OSkey{" +
                "ordineId=" + ordineId +
                ", socioId=" + socioId +
                '}';
    }
}