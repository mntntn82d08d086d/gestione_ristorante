package org.labsis.gestione_ristorante.service.gestione_pagamenti;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.repository.gestione_pagamenti.R_OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class R_OSServiceImpl implements R_OSService {

    @Autowired
    private final R_OSRepository repository;


}
