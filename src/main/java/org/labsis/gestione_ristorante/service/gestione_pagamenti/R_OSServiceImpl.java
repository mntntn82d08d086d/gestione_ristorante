package org.labsis.gestione_ristorante.service.gestione_pagamenti;

import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OS;
import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OSkey;
import org.labsis.gestione_ristorante.repository.gestione_pagamenti.R_OSRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("rosService")
@Transactional(readOnly = true)
public class R_OSServiceImpl implements R_OSService {

    private final R_OSRepository rosRepository;

    public R_OSServiceImpl(R_OSRepository rosRepository) {
        this.rosRepository = rosRepository;
    }

    @Override
    public Optional<R_OS> getR_OSById(R_OSkey id) {
        return rosRepository.findR_OSById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<R_OS> saveR_OS(R_OS ros) {
        return rosRepository.saveR_OS(ros);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<R_OS> updateR_OS(R_OS ros, R_OSkey id) {
        return rosRepository.updateR_OS(ros, id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<R_OS> deleteR_OSByKey(R_OSkey id) {
        return rosRepository.deleteR_OSByKey(id);
    }
}
