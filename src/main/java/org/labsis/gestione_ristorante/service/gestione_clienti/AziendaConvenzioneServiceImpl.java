package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.repository.risorse_umane.AziendaConvenzioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: Documentazione
 */

@Service
public class AziendaConvenzioneServiceImpl implements AziendaConvenzioneService {

    @Autowired
    private AziendaConvenzioneRepository repository;
}
