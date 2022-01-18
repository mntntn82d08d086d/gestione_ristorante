package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.repository.risorse_umane.PresenzeDipendentiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service("presenzeDipendentiService")
@Transactional
public class PresenzeDipendentiServiceImpl implements PresenzeDipendentiService {

    private final PresenzeDipendentiRepository presenzeDipendentiRepository;

    public PresenzeDipendentiServiceImpl(PresenzeDipendentiRepository presenzeDipendentiRepository) {
        this.presenzeDipendentiRepository = presenzeDipendentiRepository;
    }

    // TODO: da implementare
}
