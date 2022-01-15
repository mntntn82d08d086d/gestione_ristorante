package org.labsis.gestione_ristorante.entity.risorse_umane;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO: Documentazione
 */

@Entity
public class PermessiDipendente implements Serializable {

    @EmbeddedId
    private PermessiDipendentiKey id;

    @MapsId("dipendentePiva")
    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_piva", nullable = false)
    private Dipendente dipendente;

    @Column(name = "motivazione", nullable = false)
    private String motivazione;

    @Column(name = "retribuito", nullable = false)
    private Boolean retribuito;

    public PermessiDipendente() {
    }

    public PermessiDipendente(PermessiDipendentiKey id, Dipendente dipendente, String motivazione, Boolean retribuito) {
        this.id = id;
        this.dipendente = dipendente;
        this.motivazione = motivazione;
        this.retribuito = retribuito;
    }

    public PermessiDipendentiKey getId() {
        return id;
    }

    public void setId(PermessiDipendentiKey id) {
        this.id = id;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public Boolean getRetribuito() {
        return retribuito;
    }

    public void setRetribuito(Boolean retribuito) {
        this.retribuito = retribuito;
    }

    @Transient
    public Date getDataPermesso() {
        return id.getDataPermesso();
    }

    @Transient
    public void setDataPermesso(java.sql.Date dataPermesso) {
        id.setDataPermesso(dataPermesso);
    }

    @Transient
    public String getDipendentePiva() {
        return id.getDipendentePiva();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermessiDipendente)) return false;
        PermessiDipendente that = (PermessiDipendente) o;
        return Objects.equal(getId(), that.getId()) && Objects.equal(getDipendente(), that.getDipendente()) && Objects.equal(getMotivazione(), that.getMotivazione()) && Objects.equal(getRetribuito(), that.getRetribuito());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getDipendente(), getMotivazione(), getRetribuito());
    }

    @Override
    public String toString() {
        return "PermessiDipendente{" +
                "id=" + id +
                ", dipendente=" + dipendente +
                ", motivazione='" + motivazione + '\'' +
                ", retribuito=" + retribuito +
                '}';
    }
}