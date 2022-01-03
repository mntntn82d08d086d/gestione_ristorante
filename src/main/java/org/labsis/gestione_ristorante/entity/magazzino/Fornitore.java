package org.labsis.gestione_ristorante.entity.magazzino;

import org.labsis.gestione_ristorante.entity.common.Azienda;
import org.labsis.gestione_ristorante.entity.common.Contatto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: Documentazione
 */

@Entity(name = "Fornitore")
public class Fornitore extends Azienda implements Serializable {

    @OneToMany(fetch = javax.persistence.FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contatto> contatti = new LinkedList<>();

/*
    @OneToMany(fetch = javax.persistence.FetchType.EAGER, mappedBy = "fornitore")
    private List<R_FP> r_fp = new LinkedList<>();
*/

    public Fornitore() {
        super();
    }

    public Fornitore(String piva, String nomeAzienda, String sedeLegale, String citta) {
        super(piva, nomeAzienda, sedeLegale, citta);
    }

    public Fornitore(String piva, String nomeAzienda, String sedeLegale, String citta, Contatto contatto) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.contatti.add(contatto);
    }

    public Fornitore(String piva, String nomeAzienda, String sedeLegale, String citta, List<Contatto> contatti) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.contatti = contatti;
    }

    public Fornitore(Long id, String piva, String nomeAzienda, String sedeLegale, String citta, List<Contatto> contatti) {
        super(id, piva, nomeAzienda, sedeLegale, citta);
        this.contatti = contatti;
    }

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

/*
    public List<R_FP> getR_fp() {
        return r_fp;
    }

    public void setR_fp(List<R_FP> r_fp) {
        this.r_fp = r_fp;
    }
*/

    @Transient
    @Override
    public void addContatto(Contatto contatto) {
        contatti.add(contatto);
    }

/*
    @Transient
    public void addRfp(R_FP r) {
        r_fp.add(r);
    }

    @Transient
    public void removeRfp(R_FP r) {
        r_fp.remove(r);
    }
*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornitore)) return false;
        if (!super.equals(o)) return false;

        Fornitore fornitore = (Fornitore) o;

        return getContatti().equals(fornitore.getContatti());
        //if (!getContatti().equals(fornitore.getContatti())) return false;
        //return getR_fp().equals(fornitore.getR_fp());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getContatti().hashCode();
        //result = 31 * result + getR_fp().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Fornitore{" +
                super.toString() +
                ", contatti=" + contatti +
                //", r_fp=" + r_fp +
                '}';
    }
}
