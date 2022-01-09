package org.labsis.gestione_ristorante.entity.magazzino;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prodotto")
    @SequenceGenerator(
            name = "seq_prodotto",
            sequenceName = "seq_prodotto",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipologia", nullable = false)
    private String tipologia;

    @Column(name = "marca", nullable = false)
    private String marca;

    public Prodotto(String nome, String tipologia, String marca) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.marca = marca;
    }
}