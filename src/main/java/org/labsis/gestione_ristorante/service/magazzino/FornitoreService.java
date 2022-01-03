package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface FornitoreService {

    List<Fornitore> getAllFornitori();

    Fornitore saveFornitore(Fornitore fornitore);

    Fornitore getFornitoreById(Long id);

    Fornitore updateFornitore(Fornitore fornitore);

    void deleteFornitoreById(Long id);
}
