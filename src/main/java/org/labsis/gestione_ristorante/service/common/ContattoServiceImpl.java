package org.labsis.gestione_ristorante.service.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.repository.common.ContattoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("contattoService")
@Transactional(readOnly = true)
public class ContattoServiceImpl implements ContattoService {

    private final ContattoRepository contattoRepository;

    public ContattoServiceImpl(ContattoRepository contattoRepository) {
        this.contattoRepository = contattoRepository;
    }

    @Override
    public List<Contatto> getAllContatti() {
        return contattoRepository.findAll();
    }

    @Override
    public Optional<Contatto> getContattoById(Long id) {
        return contattoRepository.findContattoById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Contatto> saveContatto(Contatto contatto) {
        return contattoRepository.saveContatto(contatto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Contatto> updateContatto(Contatto contatto, Long id) {
        return contattoRepository.updateContatto(contatto, id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Contatto> deleteContattoById(Long id) {
        return contattoRepository.deleteContattoById(id);
    }
}
