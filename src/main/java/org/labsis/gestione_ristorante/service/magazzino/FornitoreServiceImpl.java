package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.repository.magazzino.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
public class FornitoreServiceImpl implements FornitoreService, Serializable {

    @Autowired
    private FornitoreRepository repository;

    @Override
    public List<Fornitore> getAllFornitori() {
        return repository.findAll();
    }

    @Override
    public Fornitore saveFornitore(Fornitore fornitore) {
        return repository.save(fornitore);
    }

    @Override
    public Fornitore getFornitoreById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Fornitore updateFornitore(Fornitore fornitore) {
        return repository.save(fornitore);
    }

    @Override
    public void deleteFornitoreById(Long id) {
        repository.deleteById(id);
    }
}
