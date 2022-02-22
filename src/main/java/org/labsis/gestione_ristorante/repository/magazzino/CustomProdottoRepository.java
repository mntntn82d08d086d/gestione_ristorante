package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomProdottoRepository {

    @Modifying
    Optional<Prodotto> saveProdotto(Prodotto prodotto);

    @Modifying
    Optional<Prodotto> updateProdotto(Prodotto prodotto, Long id);

    @Modifying
    Optional<Prodotto> deleteProdottoById(Long id);

}
