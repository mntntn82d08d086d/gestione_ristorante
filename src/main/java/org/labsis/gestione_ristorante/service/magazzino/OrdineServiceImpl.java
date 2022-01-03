package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.repository.magazzino.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
public class OrdineServiceImpl implements OrdineService {

    @Autowired
    private OrdineRepository repository;

    public List<Ordine> getAllOrdine() {
        return repository.findAll();
    }

    @Override
    public Ordine saveOrdine(Ordine ordine) {
        return repository.save(ordine);
    }

    @Override
    public Ordine getOrdineById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteOrdineById(Long id) {
        repository.deleteById(id);
    }
}
