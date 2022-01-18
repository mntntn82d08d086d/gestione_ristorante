package org.labsis.gestione_ristorante.service.gestione_pagamenti;

import org.labsis.gestione_ristorante.repository.gestione_pagamenti.R_OSRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service
@Transactional(readOnly = true)
public class R_OSServiceImpl implements R_OSService {

    private final R_OSRepository rosRepository;

    public R_OSServiceImpl(R_OSRepository rosRepository) {
        this.rosRepository = rosRepository;
    }

    // TODO: da implementare
}
