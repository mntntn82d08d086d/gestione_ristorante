package org.labsis.gestione_ristorante.service.risorse_umane;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.repository.risorse_umane.PermessiDipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class PermessiDipendenteServiceImpl implements PermessiDipendenteService {

    @Autowired
    private final PermessiDipendenteRepository repository;
}
