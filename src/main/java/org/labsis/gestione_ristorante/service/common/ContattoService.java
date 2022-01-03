package org.labsis.gestione_ristorante.service.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;

/**
 * TODO: Documentazione
 */

public interface ContattoService {

    Contatto getContattoById(Long id);

    Contatto saveContatto(Contatto contatto);

}
