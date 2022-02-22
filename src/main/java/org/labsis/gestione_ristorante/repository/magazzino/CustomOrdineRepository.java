package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomOrdineRepository {

    @Modifying
    Optional<Ordine> saveOrdine(Ordine ordine);

    @Modifying
    Optional<Ordine> updateOrdine(Ordine ordine, Long id);

    @Modifying
    Optional<Ordine> deleteOrdineById(Long id);

}
