package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.repository.risorse_umane.PermessiDipendenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service("permessiDipendenteService")
@Transactional
public class PermessiDipendenteServiceImpl implements PermessiDipendenteService {

    private final PermessiDipendenteRepository permessiDipendenteRepository;

    public PermessiDipendenteServiceImpl(PermessiDipendenteRepository permessiDipendenteRepository) {
        this.permessiDipendenteRepository = permessiDipendenteRepository;
    }

    // TODO: da implementare
}
