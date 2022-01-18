package org.labsis.gestione_ristorante.service.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface ContattoService {

    List<Contatto> getAllContatti();

    Optional<Contatto> getContattoById(Long id);

    Optional<Contatto> saveContatto(Contatto contatto);

    Optional<Contatto> updateContatto(Contatto contatto, Long id);

    Optional<Contatto> deleteContattoById(Long id);

}
