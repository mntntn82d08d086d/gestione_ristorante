package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomOrdineRepository {

    Optional<Ordine> saveOrdine(Ordine ordine);

    Optional<Ordine> updateOrdine(Ordine ordine, Long id);

    Optional<Ordine> deleteOrdineById(Long id);

}
