package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface ProdottoService {

    List<Prodotto> getAllProdotto();

    Optional<Prodotto> getProdottoById(Long id);

    Optional<Prodotto> saveProdotto(Prodotto prodotto);

    Optional<Prodotto> updateProdotto(Prodotto prodotto, Long id);

    Optional<Prodotto> deleteProdottoById(Long id);
}
