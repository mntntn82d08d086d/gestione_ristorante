package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface OrdineService {

    List<Ordine> getAllOrdine();

    Ordine saveOrdine(Ordine ordine);

    Ordine getOrdineById(Long id);

    void deleteOrdineById(Long id);
}
