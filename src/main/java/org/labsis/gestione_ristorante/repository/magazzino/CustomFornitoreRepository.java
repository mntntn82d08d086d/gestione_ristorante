package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomFornitoreRepository {

    Optional<Fornitore> saveFornitore(Fornitore fornitore);

    Optional<Fornitore> updateFornitore(Fornitore fornitore, String piva);

    Optional<Fornitore> deleteFornitoreByPiva(String piva);
}
