package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("ordineRepository")
public interface OrdineRepository extends JpaRepository<Ordine, Long>, CustomOrdineRepository {

    Optional<Ordine> findOrdineById(Long id);

}