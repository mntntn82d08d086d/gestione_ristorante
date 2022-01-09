package org.labsis.gestione_ristorante.entity.common;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.labsis.gestione_ristorante.entity.admin.Account;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UtenteAbstract implements Serializable {

    @Column(name = "codice_fiscale", nullable = false, length = 16)
    private String codiceFiscale;

    @Column(name = "nome", nullable = false, length = 90)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 90)
    private String cognome;

    @Column(name = "data_di_nascita")
    private Date dataDiNascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract Account getAccount();

    public abstract void setAccount(Account account);

}