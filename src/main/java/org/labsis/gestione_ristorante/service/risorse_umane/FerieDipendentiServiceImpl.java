package org.labsis.gestione_ristorante.service.risorse_umane;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.repository.risorse_umane.FerieDipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class FerieDipendentiServiceImpl implements FerieDipendentiService{

    @Autowired
    private final FerieDipendentiRepository repository;
}
