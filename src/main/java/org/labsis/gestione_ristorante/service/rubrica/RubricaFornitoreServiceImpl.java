package org.labsis.gestione_ristorante.service.rubrica;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.repository.rubrica.RubricaFornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RubricaFornitoreServiceImpl implements RubricaFornitoreService {

    @Autowired
    private final RubricaFornitoreRepository repository;

}
