package org.labsis.gestione_ristorante.service.gestione_pagamenti;

import org.labsis.gestione_ristorante.repository.gestione_pagamenti.R_OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: Documentazione
 */

@Service
public class R_OSServiceImpl implements R_OSService {

    @Autowired
    private R_OSRepository repository;


}
