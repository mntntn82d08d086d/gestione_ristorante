package org.labsis.gestione_ristorante.service.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.repository.common.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: Documentazione
 */

@Service
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private ContattoRepository repository;

    @Override
    public Contatto getContattoById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Contatto saveContatto(Contatto contatto) {
        return repository.save(contatto);
    }
}
