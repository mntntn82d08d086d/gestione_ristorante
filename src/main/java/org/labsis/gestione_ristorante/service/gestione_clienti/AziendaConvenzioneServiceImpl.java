package org.labsis.gestione_ristorante.service.gestione_clienti;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.repository.risorse_umane.AziendaConvenzioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class AziendaConvenzioneServiceImpl implements AziendaConvenzioneService {

    @Autowired
    private final AziendaConvenzioneRepository repository;
}
