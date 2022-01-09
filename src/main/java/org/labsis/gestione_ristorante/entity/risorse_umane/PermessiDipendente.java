package org.labsis.gestione_ristorante.entity.risorse_umane;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}