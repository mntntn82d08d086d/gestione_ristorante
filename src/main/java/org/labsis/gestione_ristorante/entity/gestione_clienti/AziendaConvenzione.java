package org.labsis.gestione_ristorante.entity.gestione_clienti;

import lombok.*;
import org.labsis.gestione_ristorante.entity.common.AziendaAbstract;
import org.labsis.gestione_ristorante.entity.common.Contatto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AziendaConvenzione extends AziendaAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_azienda_conv")
    @SequenceGenerator(
            name = "seq_azienda_conv",
            sequenceName = "seq_azienda_conv",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

/*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contatto> contatti = new LinkedList<>();
*/

    @Column(unique = true, length = 10)
    private String prefixTessera;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(unique = true)
    private Convenzione convenzione = new Convenzione();

    public AziendaConvenzione(String piva, String nomeAzienda, String sedeLegale, String citta, /*List<Contatto> contatti,*/ String prefixTessera, Convenzione convenzione) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.prefixTessera = prefixTessera;
        this.convenzione = convenzione;
    }

/*
    @Override
    public List<Contatto> getContatti() {
        return contatti;
    }

    @Override
    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti;
    }

    @Override
    public void addContatto(Contatto contatto) {
        contatti.add(contatto);
    }

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

    protected String generatePrefix(String piva, String nomeAzienda, String citta) {
        String ret = "";
        if(nomeAzienda == null || nomeAzienda.isEmpty()) return ret;
        ret += nomeAzienda.substring(0, 4);
        ret += piva.substring(5, 8);
        ret += citta.substring(0, 3);
        return ret;
    }

}