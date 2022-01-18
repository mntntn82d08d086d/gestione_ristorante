package org.labsis.gestione_ristorante.repository.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;

import java.util.Optional;

public interface CustomContattoRepository {

    Optional<Contatto> saveContatto(Contatto contatto);

    Optional<Contatto> updateContatto(Contatto contatto, Long id);

    Optional<Contatto> deleteContattoById(Long id);

}
