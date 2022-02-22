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

    @Column(name = "socio_codice_fiscale", nullable = false)
    private String socioCodicefiscale;

    public R_OSkey() {
    }

    public R_OSkey(Long ordineId, String socioCodicefiscale) {
        this.ordineId = ordineId;
        this.socioCodicefiscale = socioCodicefiscale;
    }

    public Long getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(Long ordineId) {
        this.ordineId = ordineId;
    }

    public String getSocioPiva() {
        return socioCodicefiscale;
    }

    public void setSocioPiva(String socioCodicefiscale) {
        this.socioCodicefiscale = socioCodicefiscale;
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
                ", socioCodicefiscale=" + socioCodicefiscale +
                '}';
    }
}