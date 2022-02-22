package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomFornitoreRepository {

    @Modifying
    Optional<Fornitore> saveFornitore(Fornitore fornitore);

    @Modifying
    Optional<Fornitore> updateFornitore(Fornitore fornitore, String piva);

    @Modifying
    Optional<Fornitore> deleteFornitoreByPiva(String piva);
}
