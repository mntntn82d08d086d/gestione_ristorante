package org.labsis.gestione_ristorante.entity.admin;

import com.google.common.base.Objects;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.common.UtenteAbstract;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * TODO: Documentazione
 */

@Entity
public class Socio extends UtenteAbstract {

    @OneToMany
    @JoinTable(
            name = "rubrica_socio",
            joinColumns = @JoinColumn(name = "socio_codice_fiscale", referencedColumnName = "codice_fiscale",
                    foreignKey = @ForeignKey(name = "s_cod_fis_fk")),
            inverseJoinColumns = @JoinColumn(name = "contatto_id",
                    foreignKey = @ForeignKey(name = "s_contatto_id_fk")),
            uniqueConstraints = @UniqueConstraint(name = "s_contatto_id_unique", columnNames = "contatto_id"),
            indexes = @Index(name = "s_cod_fis_idx", columnList = "socio_codice_fiscale")
    )
    private Set<Contatto> contatti;

    @OneToOne(optional = false, orphanRemoval = true)
    private Account account;

    public Socio() {
        super();
        this.account = new Account();
    }

    public Socio(String codiceFiscale, String nome, String cognome, Date dataDiNascita, String indirizzo, String citta, Account account) {
        super(codiceFiscale, nome, cognome, dataDiNascita, indirizzo, citta);
        this.account = account;
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
        if (!(o instanceof Socio)) return false;
        if (!super.equals(o)) return false;
        Socio socio = (Socio) o;
        return Objects.equal(getContatti(), socio.getContatti()) && Objects.equal(getAccount(), socio.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getContatti(), getAccount());
    }

    @Override
    public String toString() {
        return "Socio{" +
                super.toString() +
                ", contatti=" + contatti +
                ", account=" + account +
                '}';
    }
}