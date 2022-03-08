package org.labsis.gestione_ristorante.entity.risorse_umane;

import com.google.common.base.Objects;
import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.common.UtenteAbstract;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO: Documentazione
 */

@Entity
public class Dipendente extends UtenteAbstract {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rubrica_dipendente",
            joinColumns = @JoinColumn(name = "dipendente_codice_fiscale", referencedColumnName = "codice_fiscale",
                    foreignKey = @ForeignKey(name = "d_cod_fis_fk")),
            inverseJoinColumns = @JoinColumn(name = "contatto_id",
                    foreignKey = @ForeignKey(name = "d_contatto_id_fk")),
            uniqueConstraints = @UniqueConstraint(name = "d_contatto_id_unique", columnNames = "contatto_id"),
            indexes = @Index(name = "d_cod_fis_idx", columnList = "dipendente_codice_fiscale")
    )
    private Set<Contatto> contatti;

    @Column(name = "ferie_da_contratto", nullable = false)
    private Integer ferieDaContratto;

    @Column(name = "permessi_da_contratto", nullable = false)
    private Integer permessiDaContratto;

    @Column(name = "mansione", length = 20, nullable = false)
    private String mansione;

    @OneToOne(orphanRemoval = true)
    @JoinColumns({
            @JoinColumn(name = "username", referencedColumnName = "username"),
            @JoinColumn(name = "email", referencedColumnName = "email")
    })
    private Account account;

    public Dipendente() {
        super();
        account = new Account();
        contatti = new LinkedHashSet<>();
    }

    public Dipendente(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo,
                      String citta, Integer ferieDaContratto, Integer permessiDaContratto,
                      String mansione, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.ferieDaContratto = ferieDaContratto;
        this.permessiDaContratto = permessiDaContratto;
        this.mansione = mansione;
        this.account = account;
    }

    public Integer getFerieDaContratto() {
        return ferieDaContratto;
    }

    public void setFerieDaContratto(Integer ferieDaContratto) {
        this.ferieDaContratto = ferieDaContratto;
    }

    public Integer getPermessiDaContratto() {
        return permessiDaContratto;
    }

    public void setPermessiDaContratto(Integer permessiDaContratto) {
        this.permessiDaContratto = permessiDaContratto;
    }

    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    @Override
    public Set<Contatto> getContatti() {
        return contatti;
    }

    @Override
    public void setContatti(Set<Contatto> contatti) {
        this.contatti = contatti;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dipendente)) return false;
        if (!super.equals(o)) return false;
        Dipendente that = (Dipendente) o;
        return Objects.equal(getContatti(), that.getContatti()) && Objects.equal(getFerieDaContratto(), that.getFerieDaContratto()) && Objects.equal(getPermessiDaContratto(), that.getPermessiDaContratto()) && Objects.equal(getMansione(), that.getMansione()) && Objects.equal(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getContatti(), getFerieDaContratto(), getPermessiDaContratto(), getMansione(), getAccount());
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                super.toString() +
                ", contatti=" + contatti +
                ", ferieDaContratto=" + ferieDaContratto +
                ", permessiDaContratto=" + permessiDaContratto +
                ", mansione='" + mansione + '\'' +
                ", account=" + account +
                '}';
    }

    public enum EnumMansione {
        NS("Non Specificato"), MAGAZZINIERE("Magazziniere"), CASSIERE("Cassiere"),
        CAMERIERE("Cameriere"), RIDER("Rider"), BRAND_AMBASSADOR("Brand Ambassador"),
        CUOCO("Cuoco"), PINSAIOLO("Pinsaiolo");

        EnumMansione(String mansione) {
            this.mansione = mansione;
        }
        private String mansione;

        public String getMansione() {
            return mansione;
        }

        public void setMansione(String mansione) {
            this.mansione = mansione;
        }

    }
}
