package org.labsis.gestione_ristorante.entity.magazzino;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity(name = "Prodotto")
@Table(name = "prodotto")
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipologia", nullable = false)
    private String tipologia;

    @Column(name = "marca", nullable = false)
    private String marca;

/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "prodotto")
    private Set<R_FP> r_fp = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "prodotto")
    private Set<R_PO> r_po = new LinkedHashSet<>();
*/

    public Prodotto() {
    }

    public Prodotto(String nome, String tipologia, String marca) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.marca = marca;
    }

    public Prodotto(Long id, String nome, String tipologia, String marca) {
        this.id = id;
        this.nome = nome;
        this.tipologia = tipologia;
        this.marca = marca;
    }

/*

    public Prodotto(Long id, String nome, String tipologia, String marca, Set<R_FP> r_fp, Set<R_PO> r_po) {
        this.id = id;
        this.nome = nome;
        this.tipologia = tipologia;
        this.marca = marca;
        this.r_fp = r_fp;
        this.r_po = r_po;
    }
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

/*
    public Set<R_FP> getR_fp() {
        return r_fp;
    }

    public void setR_fp(Set<R_FP> r_fp) {
        this.r_fp = r_fp;
    }

    public Set<R_PO> getR_po() {
        return r_po;
    }

    public void setR_po(Set<R_PO> r_po) {
        this.r_po = r_po;
    }

    @Transient
    public void addRfp(R_FP r) {
        r_fp.add(r);
    }

    @Transient
    public void removeRfp(R_FP r) {
        r_fp.add(r);
    }

    @Transient
    public void addRpo(R_PO r) {
        r_po.add(r);
    }

    @Transient
    public void removeRpo(R_PO r) {
        r_po.remove(r);
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prodotto)) return false;

        Prodotto prodotto = (Prodotto) o;

        if (!getId().equals(prodotto.getId())) return false;
        if (!getNome().equals(prodotto.getNome())) return false;
        if (!getTipologia().equals(prodotto.getTipologia())) return false;
        return getMarca().equals(prodotto.getMarca());
/*
        if (!getMarca().equals(prodotto.getMarca())) return false;
        if (getR_fp() != null ? !getR_fp().equals(prodotto.getR_fp()) : prodotto.getR_fp() != null) return false;
        return getR_po() != null ? getR_po().equals(prodotto.getR_po()) : prodotto.getR_po() == null;
*/
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getTipologia().hashCode();
        result = 31 * result + getMarca().hashCode();
/*
        result = 31 * result + (getR_fp() != null ? getR_fp().hashCode() : 0);
        result = 31 * result + (getR_po() != null ? getR_po().hashCode() : 0);
*/
        return result;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", marca='" + marca + '\'' +
/*
                ", r_fp=" + r_fp +
                ", r_po=" + r_po +
*/
                '}';
    }
}