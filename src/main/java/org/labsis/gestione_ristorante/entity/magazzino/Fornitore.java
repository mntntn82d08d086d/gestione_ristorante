package org.labsis.gestione_ristorante.entity.magazzino;

import lombok.*;
import org.labsis.gestione_ristorante.entity.common.AziendaAbstract;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fornitore extends AziendaAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fornitore")
    @SequenceGenerator(
            name = "seq_fornitore",
            sequenceName = "seq_fornitore",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    public Fornitore(String piva, String nomeAzienda, String sedeLegale, String citta) {
        super(piva, nomeAzienda, sedeLegale, citta);
    }

/*
    @Transient
    @Override
    public List<Contatto> getContatti() {
        return contatti;
    }

    @Transient
    @Override
    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti;
    }

    @Transient
    @Override
    public void addContatto(Contatto contatto) {
        contatti.add(contatto);
    }

    @Transient
    @Override
    public void removeContattoByTipologia(String tipologia) {
        if(!contatti.isEmpty()) {
            for (Contatto c : contatti) {
                if(c.getTipologia().equals(tipologia)){
                    contatti.remove(c);
                    break;
                }
            }
        }
    }

    @Transient
    @Override
    public void removeContattoByTipologiaAndSuffix(String tipologia, String suffix) {
        if(!contatti.isEmpty()) {
            for (Contatto c : contatti) {
                if(c.getTipologia().equals(tipologia) && c.getSuffix().equals(suffix)){
                    contatti.remove(c);
                    break;
                }
            }
        }
    }
*/

}
