package org.labsis.gestione_ristorante.entity.risorse_umane;

import org.labsis.gestione_ristorante.entity.common.Azienda;
import org.labsis.gestione_ristorante.entity.common.Contatto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: Documentazione
 */

@Entity(name = "AziendaConvenzione")
public class AziendaConvenzione extends Azienda implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contatto> contatti = new LinkedList<>();

    @Column(name = "prefix_tessera", unique = true, length = 10)
    private String prefixTessera;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "convenzione_id", unique = true)
    private Convenzione convenzione = new Convenzione();

    public AziendaConvenzione() {
        super();
    }

    public AziendaConvenzione(String piva, String nomeAzienda, String sedeLegale, String citta, List<Contatto> contatti, String prefixTessera, Convenzione convenzione) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.contatti = contatti;
        this.prefixTessera = prefixTessera;
        this.convenzione = convenzione;
    }

    public AziendaConvenzione(Long id, String piva, String nomeAzienda, String sedeLegale, String citta, List<Contatto> contatti, String prefixTessera, Convenzione convenzione) {
        super(id, piva, nomeAzienda, sedeLegale, citta);
        this.contatti = contatti;
        this.prefixTessera = prefixTessera;
        this.convenzione = convenzione;
    }

    public String getPrefixTessera() {
        return prefixTessera;
    }

    public void setPrefixTessera(String prefixTessera) {
        this.prefixTessera = prefixTessera;
    }

    public Convenzione getConvenzione() {
        return convenzione;
    }

    public void setConvenzione(Convenzione convenzione) {
        this.convenzione = convenzione;
    }

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

    protected String generatePrefix(String piva, String nomeAzienda, String citta) {
        String ret = "";
        if(nomeAzienda == null || nomeAzienda.isEmpty()) return ret;
        ret += nomeAzienda.substring(0, 4);
        ret += piva.substring(5, 8);
        ret += citta.substring(0, 3);
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AziendaConvenzione)) return false;
        if (!super.equals(o)) return false;

        AziendaConvenzione that = (AziendaConvenzione) o;

        if (getContatti() != null ? !getContatti().equals(that.getContatti()) : that.getContatti() != null)
            return false;
        if (!getPrefixTessera().equals(that.getPrefixTessera())) return false;
        return getConvenzione() != null ? getConvenzione().equals(that.getConvenzione()) : that.getConvenzione() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 3 * result + (getContatti() != null ? getContatti().hashCode() : 0);
        result = 5 * result + getPrefixTessera().hashCode();
        result = 7 * result + (getConvenzione() != null ? getConvenzione().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AziendaConvenzione{" +
                "contatti=" + contatti +
                ", prefixTessera='" + prefixTessera + '\'' +
                ", convenzione=" + convenzione +
                '}';
    }
}