package org.labsis.gestione_ristorante.entity.common;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity(name = "Contatto")
public class Contatto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipologia", length = 20, nullable = false)
    private String tipologia;

    @Column(name = "suffix", length = 20)
    private String suffix;

    @Column(name = "contatto", length = 50, nullable = false)
    private String contatto;

    public Contatto() {
        this.suffix = "";
    }

    public Contatto(String tipologia, String contatto) {
        this.tipologia = tipologia;
        this.contatto = contatto;
    }

    public Contatto(String tipologia, String suffix, String contatto) {
        this.tipologia = tipologia;
        this.suffix = suffix;
        this.contatto = contatto;
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

        if (!getId().equals(contatto1.getId())) return false;
        if (getTipologia() != contatto1.getTipologia()) return false;
        if (getSuffix() != contatto1.getSuffix()) return false;
        return getContatto().equals(contatto1.getContatto());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTipologia().hashCode();
        result = 31 * result + (getSuffix() != null ? getSuffix().hashCode() : 0);
        result = 31 * result + getContatto().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "id=" + id +
                ", tipologia=" + tipologia +
                ", suffix=" + suffix +
                ", contatto='" + contatto + '\'' +
                '}';
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
