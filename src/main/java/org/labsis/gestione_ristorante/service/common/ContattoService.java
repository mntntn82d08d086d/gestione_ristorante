package org.labsis.gestione_ristorante.service.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface ContattoService {

    List<Contatto> getAllContatti();

    Contatto getContattoById(Long id);

    Contatto saveContatto(Contatto contatto);

    void deleteContattoById(Long id);

}
