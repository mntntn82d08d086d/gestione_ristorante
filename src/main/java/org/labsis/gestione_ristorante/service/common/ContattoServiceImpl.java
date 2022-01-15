package org.labsis.gestione_ristorante.service.common;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.repository.common.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private final ContattoRepository repository;

    @Override
    public List<Contatto> getAllContatti() {
        return repository.findAll();
    }

    @Override
    public Contatto getContattoById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Contatto saveContatto(Contatto contatto) {
        return repository.save(contatto);
    }

    @Override
    public void deleteContattoById(Long id) {
        repository.deleteById(id);
    }
}
