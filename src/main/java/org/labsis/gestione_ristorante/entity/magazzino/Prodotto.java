package org.labsis.gestione_ristorante.entity.magazzino;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prodotto")
    @SequenceGenerator(
            name = "seq_prodotto",
            sequenceName = "seq_prodotto",
            allocationSize = 1
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipologia", nullable = false)
    private String tipologia;

    @Column(name = "marca", nullable = false)
    private String marca;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prodotto)) return false;
        Prodotto prodotto = (Prodotto) o;
        return Objects.equal(getId(), prodotto.getId()) && Objects.equal(getNome(), prodotto.getNome()) && Objects.equal(getTipologia(), prodotto.getTipologia()) && Objects.equal(getMarca(), prodotto.getMarca());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getNome(), getTipologia(), getMarca());
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}