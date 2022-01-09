package org.labsis.gestione_ristorante.entity.magazzino;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ordine")
    @SequenceGenerator(
            name = "seq_ordine",
            sequenceName = "seq_ordine",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codice_ordine", nullable = false, unique = true, length = 90)
    private String codiceOrdine;

    @Column(name = "data_richiesta", nullable = false)
    private Date dataRichiesta;

    @Column(name = "ordine_evaso")
    private Boolean ordineEvaso = false;

    @Lob
    @Column(name = "nota")
    private String nota;

/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ordine")
    @ToString.Exclude
    private Set<R_PO> r_po = new java.util.LinkedHashSet<>();

    @OneToMany
    private Set<R_OS> r_os;
*/

    public Ordine(String codiceOrdine, Date dataRichiesta, Boolean ordineEvaso, String nota) {
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
        this.ordineEvaso = ordineEvaso;
        this.nota = nota;
    }

    public Ordine(String codiceOrdine, Date dataRichiesta, String nota) {
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
        this.nota = nota;
    }

    public Ordine(String codiceOrdine, Date dataRichiesta) {
        this.codiceOrdine = codiceOrdine;
        this.dataRichiesta = dataRichiesta;
    }

/*
    @Transient
    public void addRpo(R_PO r) {
        r_po.add(r);
    }

    @Transient
    public void removeRpo(R_PO r) {
        r_po.remove(r);
    }
*/

}