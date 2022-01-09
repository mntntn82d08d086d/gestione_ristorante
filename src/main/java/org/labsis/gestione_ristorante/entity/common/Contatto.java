package org.labsis.gestione_ristorante.entity.common;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contatto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contatto")
    @SequenceGenerator(
            name = "seq_contatto",
            sequenceName = "seq_contatto",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipologia", length = 20, nullable = false)
    private String tipologia;

    @Column(name = "suffix", length = 20)
    private String suffix;

    @Column(name = "contatto", length = 50, nullable = false)
    private String contatto;

    public Contatto(String tipologia, String contatto) {
        this.tipologia = tipologia;
        this.contatto = contatto;
    }

    public Contatto(String tipologia, String suffix, String contatto) {
        this.tipologia = tipologia;
        this.suffix = suffix;
        this.contatto = contatto;
    }

    public enum EnumSuffix {
        NS(""), PRINCIPALE("Principale"), SECONDARIO("Secondario"), LAVORO("Lavoro"), PERSONALE("Personale");

        EnumSuffix(String suffix) {
            this.mansione = mansione;
        }

        private String mansione;
    }

    public enum EnumTipologia {
        NS(""), EMAIL("Email"), TELEFONO("Telefono"), FAX("Fax");

        EnumTipologia(String tipologia) {
            this.mansione = mansione;
        }
        private String mansione;
    }
}
