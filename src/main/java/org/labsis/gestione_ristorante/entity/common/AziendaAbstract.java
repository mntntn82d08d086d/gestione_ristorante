package org.labsis.gestione_ristorante.entity.common;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * TODO: Documentazione
 */

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AziendaAbstract implements Serializable {

    @Column(name = "piva", length = 21, nullable = false)
    private String piva;

    @Column(name = "nome_azienda", nullable = false)
    private String nomeAzienda;

    @Column(name = "sede_legale", nullable = false)
    private String sedeLegale;

    @Column(name = "citta", nullable = false)
    private String citta;

/*
    @Transient
    public abstract List<Contatto> getContatti();

    @Transient
    public abstract void setContatti(List<Contatto> contatti);

    @Transient
    public abstract void addContatto(Contatto contatto);

    @Transient
    public abstract void removeContattoByTipologia(String tipologia);

    @Transient
    public abstract void removeContattoByTipologiaAndSuffix(String tipologia, String suffix);
*/
}
