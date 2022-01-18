package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface FornitoreService {

    List<Fornitore> getAllFornitori();

    Optional<Fornitore> getFornitoreByPiva(String piva);

    Optional<Fornitore> saveFornitore(Fornitore fornitore);

    Optional<Fornitore> updateFornitore(Fornitore fornitore, String piva);

    Optional<Fornitore> deleteFornitoreByPiva(String piva);
}
