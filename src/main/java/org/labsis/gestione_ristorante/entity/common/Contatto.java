package org.labsis.gestione_ristorante.entity.common;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
public class Contatto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contatto")
    @SequenceGenerator(
            name = "seq_contatto",
            sequenceName = "seq_contatto",
            allocationSize = 1
    )
    @Column(name = "contatto_id", nullable = false)
    private Long id;

    @Column(name = "tipologia", length = 20, nullable = false)
    private String tipologia;

    @Column(name = "suffix", length = 20)
    private String suffix;

    @Column(name = "contatto", length = 50, nullable = false)
    private String contatto;

    public Contatto() {
    }

    public Contatto(Long id, String tipologia, String suffix, String contatto) {
        this.id = id;
        this.tipologia = tipologia;
        this.suffix = suffix;
        this.contatto = contatto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContatto() {
        return contatto;
    }

    public void setContatto(String contatto) {
        this.contatto = contatto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contatto)) return false;
        Contatto contatto1 = (Contatto) o;
        return Objects.equal(getId(), contatto1.getId()) && Objects.equal(getTipologia(), contatto1.getTipologia()) && Objects.equal(getSuffix(), contatto1.getSuffix()) && Objects.equal(getContatto(), contatto1.getContatto());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getTipologia(), getSuffix(), getContatto());
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "id=" + id +
                ", tipologia='" + tipologia + '\'' +
                ", suffix='" + suffix + '\'' +
                ", contatto='" + contatto + '\'' +
                '}';
    }

    public enum EnumSuffix {
        NS(""), PRINCIPALE("Principale"), SECONDARIO("Secondario"), LAVORO("Lavoro"), PERSONALE("Personale");

        EnumSuffix(String suffix) {
            this.suffix = suffix;
        }

        private String suffix;

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        @Override
        public String toString() {
            return suffix;
        }
    }

    public enum EnumTipologia {
        NS(""), EMAIL("Email"), TELEFONO("Telefono"), FAX("Fax");

        EnumTipologia(String tipologia) {
            this.tipologia = tipologia;
        }
        private String tipologia;

        public String getTipologia() {
            return tipologia;
        }

        public void setTipologia(String tipologia) {
            this.tipologia = tipologia;
        }

        @Override
        public String toString() {
            return tipologia;
        }
    }
}
