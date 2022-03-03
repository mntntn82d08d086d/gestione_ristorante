package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("ordineRepository")
public interface OrdineRepository extends JpaRepository<Ordine, Long>, CustomOrdineRepository {

    Optional<Ordine> findOrdineById(Long id);

    @Query("SELECT p FROM Prodotto p where p.id in (\n" +
            "    SELECT r.prodotto\n" +
            "    FROM R_PO r\n" +
            "    WHERE r.ordine.id = ?1\n" +
            ")")
    List<Prodotto> findAllProdottiInOrdine(Long id);
}