package org.labsis.gestione_ristorante.entity.gestione_clienti;

import com.google.common.base.Objects;
import org.labsis.gestione_ristorante.entity.common.AziendaAbstract;
import org.labsis.gestione_ristorante.entity.common.Contatto;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO: Documentazione
 */

@Entity(name = "AziendaConvenzione")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "nome_azienda_unique", columnNames = "nome_azienda"),
        @UniqueConstraint(name = "prefix_tessera_unique", columnNames = "prefix_tessera"),
        @UniqueConstraint(name = "convenzione_unique", columnNames = "convenzione_id")}
)
public class AziendaConvenzione extends AziendaAbstract {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rubrica_azienda_convenzione",
            joinColumns = @JoinColumn(name = "azienda_convenzione_piva", referencedColumnName = "piva",
                    foreignKey = @ForeignKey(name = "ac_piva_fk")),
            inverseJoinColumns = @JoinColumn(name = "contatto_id",
                    foreignKey = @ForeignKey(name = "ac_contatto_id_fk")),
            uniqueConstraints = @UniqueConstraint(name = "ac_contatto_id_unique", columnNames = "contatto_id"),
            indexes = @Index(name = "ac_piva_idx", columnList = "azienda_convenzione_piva")
    )
    private Set<Contatto> contatti = new LinkedHashSet<>();

    @Column(name = "prefix_tessera", length = 10)
    private String prefixTessera;

    @OneToOne
    @JoinColumn(name = "convenzione_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ac_convenzione_id"))
    private Convenzione convenzione;

    public AziendaConvenzione() {
        super();
    }

    public AziendaConvenzione(String piva, String nomeAzienda, String sedeLegale, String citta, String prefixTessera,
                              Convenzione convenzione, Set<Contatto> contatti) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.contatti = contatti;
        this.prefixTessera = prefixTessera;
        this.convenzione = convenzione;
    }

    public AziendaConvenzione(String piva, String nomeAzienda, String sedeLegale, String citta, String prefixTessera) {
        super(piva, nomeAzienda, sedeLegale, citta);
        this.prefixTessera = prefixTessera;
        contatti = new LinkedHashSet<>();
        convenzione = new Convenzione();
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
            boolean cannotInsert = Objects.equal(c.getTipologia(), contatto.getTipologia()) &&
                    Objects.equal(c.getSuffix(), contatto.getSuffix()) && Objects.equal(c.getContatto(), contatto.getContatto());
            if(cannotInsert)
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

    @Transient
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
        return Objects.equal(getContatti(), that.getContatti()) && Objects.equal(getPrefixTessera(), that.getPrefixTessera()) && Objects.equal(getConvenzione(), that.getConvenzione());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getContatti(), getPrefixTessera(), getConvenzione());
    }

    @Override
    public String toString() {
        return "AziendaConvenzione{" +
                super.toString() +
                ", contatti=" + contatti +
                ", prefixTessera='" + prefixTessera + '\'' +
                ", convenzione=" + convenzione +
                '}';
    }
}