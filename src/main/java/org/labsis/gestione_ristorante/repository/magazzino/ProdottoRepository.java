package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("prodottoRepository")
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>, CustomProdottoRepository {

    Optional<Prodotto> findProdottoById(Long id);

}