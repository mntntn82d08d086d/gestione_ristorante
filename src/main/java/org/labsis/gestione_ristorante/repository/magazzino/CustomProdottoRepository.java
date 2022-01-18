package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomProdottoRepository {

    Optional<Prodotto> saveProdotto(Prodotto prodotto);

    Optional<Prodotto> updateProdotto(Prodotto prodotto, Long id);

    Optional<Prodotto> deleteProdottoById(Long id);

}
