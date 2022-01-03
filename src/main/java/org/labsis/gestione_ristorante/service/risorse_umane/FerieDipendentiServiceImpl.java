package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.repository.risorse_umane.FerieDipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: Documentazione
 */

@Service
public class FerieDipendentiServiceImpl implements FerieDipendentiService{

    @Autowired
    private FerieDipendentiRepository repository;
}
