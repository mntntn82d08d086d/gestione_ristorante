package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: Documentazione
 */

public interface ProdottoService {

    List<Prodotto> getAllProdotto();

    Prodotto saveProdotto(Prodotto prodotto);

    Prodotto getProdottoById(Long id);

    Prodotto updateProdotto(Prodotto prodotto);

    void deleteProdottoById(Long id);
}
