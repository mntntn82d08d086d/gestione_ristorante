package org.labsis.gestione_ristorante.entity.magazzino;

import com.google.common.base.Objects;
import org.labsis.gestione_ristorante.entity.common.AziendaAbstract;
import org.labsis.gestione_ristorante.entity.common.Contatto;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Entità fornitore che rappresenta un generico fornitore nel database.
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "nome_azienda_unique", columnNames = "nome_azienda"))
public class Fornitore extends AziendaAbstract {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rubrica_fornitore",
            joinColumns = @JoinColumn(name = "fornitore_piva", referencedColumnName = "piva",
                    foreignKey = @ForeignKey(name = "f_piva_fk")),
            inverseJoinColumns = @JoinColumn(name = "contatto_id",
                    foreignKey = @ForeignKey(name = "f_contatto_id_fk")),
            uniqueConstraints = @UniqueConstraint(name = "f_contatto_id_unique", columnNames = "contatto_id"),
            indexes = @Index(name = "f_piva_idx", columnList = "fornitore_piva")
    )
    private Set<Contatto> contatti;

    public Fornitore() {
        super();
        contatti = new LinkedHashSet<>();
    }

    public Fornitore(String piva, String nomeAzienda, String sedeLegale, String citta) {
        super(piva, nomeAzienda, sedeLegale, citta);
        contatti = new LinkedHashSet<>();
    }

    public Fornitore(String piva, String nomeAzienda, String sedeLegale, String citta, Set<Contatto> contatti) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.contatti = contatti;
    }

    @Override
    public Set<Contatto> getContatti() {
        return contatti;
    }

    @Override
    public void setContatti(Set<Contatto> contatti) {
        this.contatti = contatti;
    }

    @Transient
    @Override
    public boolean addContatto(Contatto contatto) {
        for (Contatto c : contatti) {
            // TODO: da rivedere la logica
            boolean cannotInsert = Objects.equal(c.getTipologia(), contatto.getTipologia()) &&
                    Objects.equal(c.getSuffix(), contatto.getSuffix()) && Objects.equal(c.getContatto(), contatto.getContatto());
            if (cannotInsert)
                return false;
        }
        contatti.add(contatto);
        return true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornitore)) return false;
        if (!super.equals(o)) return false;
        Fornitore fornitore = (Fornitore) o;
        return Objects.equal(getContatti(), fornitore.getContatti());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getContatti());
    }

    @Override
    public String toString() {
        return "Fornitore{" +
                super.toString() +
                ", contatti=" + contatti +
                '}';
    }
}
