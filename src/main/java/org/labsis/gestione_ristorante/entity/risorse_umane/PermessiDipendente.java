package org.labsis.gestione_ristorante.entity.risorse_umane;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO: Documentazione
 */

@Entity(name = "PermessiDipendenti")
@Table(name = "permessi_dipendente")
public class PermessiDipendente implements Serializable {

    @EmbeddedId
    private PermessiDipendentiKey id;

    @MapsId("dipendenteId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_id", nullable = false)
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
    public Long getDipendenteId() {
        return id.getDipendenteId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PermessiDipendente)) return false;

        PermessiDipendente that = (PermessiDipendente) o;

        if (!getId().equals(that.getId())) return false;
        if (!getDipendente().equals(that.getDipendente())) return false;
        if (!getMotivazione().equals(that.getMotivazione())) return false;
        return getRetribuito() != null ? getRetribuito().equals(that.getRetribuito()) : that.getRetribuito() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 3 * result + getDipendente().hashCode();
        result = 5 * result + getMotivazione().hashCode();
        result = 7 * result + (getRetribuito() != null ? getRetribuito().hashCode() : 0);
        return result;
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