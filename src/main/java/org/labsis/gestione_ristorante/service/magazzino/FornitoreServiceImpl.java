package org.labsis.gestione_ristorante.service.magazzino;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.repository.magazzino.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class FornitoreServiceImpl implements FornitoreService {

    @Autowired
    private final FornitoreRepository repository;

    @Override
    public List<Fornitore> getAllFornitori() {
        return repository.findAll();
    }

    @Override
    public Fornitore saveFornitore(Fornitore fornitore) {
        return repository.save(fornitore);
    }

    @Override
    public Fornitore getFornitoreById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Fornitore updateFornitore(Fornitore fornitore) {
        return repository.save(fornitore);
    }

    @Override
    public void deleteFornitoreById(String id) {
        repository.deleteById(id);
    }
}
