package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.repository.risorse_umane.FerieDipendentiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service("ferieDipendentiService")
@Transactional(readOnly = true)
public class FerieDipendentiServiceImpl implements FerieDipendentiService{

    private final FerieDipendentiRepository ferieDipendentiRepositoryy;

    public FerieDipendentiServiceImpl(FerieDipendentiRepository ferieDipendentiRepositoryy) {
        this.ferieDipendentiRepositoryy = ferieDipendentiRepositoryy;
    }

    // TODO: da implementare
}
