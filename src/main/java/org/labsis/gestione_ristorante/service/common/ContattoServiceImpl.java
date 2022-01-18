package org.labsis.gestione_ristorante.service.common;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.repository.common.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequiredArgsConstructor
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private final ContattoRepository contattoRepository;

    @Override
    public List<Contatto> getAllContatti() {
        return contattoRepository.findAll();
    }

    @Override
    public Optional<Contatto> getContattoById(Long id) {
        return contattoRepository.findById(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Contatto> saveContatto(Contatto contatto) {
        return contattoRepository.saveContatto(contatto);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Contatto> updateContatto(Contatto contatto, Long id) {
        return Optional.empty();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Contatto> deleteContattoById(Long id) {
        contattoRepository.deleteById(id);
        return null;
    }
}
