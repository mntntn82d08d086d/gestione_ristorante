package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface OrdineService {

    List<Ordine> getAllOrdine();

    List<Prodotto> getAllProdottiInOrdine(long id);

    Optional<Ordine> getOrdineById(Long id);

    Optional<Ordine> saveOrdine(Ordine ordine);

    Optional<Ordine> updateOrdine(Ordine ordine, Long id);

    Optional<Ordine> deleteOrdineById(Long id);
}
