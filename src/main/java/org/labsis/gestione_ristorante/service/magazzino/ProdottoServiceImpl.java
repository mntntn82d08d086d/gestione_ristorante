package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.repository.magazzino.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
public class ProdottoServiceImpl implements ProdottoService {

    @Autowired
    private ProdottoRepository repository;

    @Override
    public List<Prodotto> getAllProdotto() {
        return repository.findAll();
    }

    @Override
    public Prodotto saveProdotto(Prodotto prodotto) {
        return repository.save(prodotto);
    }

    @Override
    public Prodotto getProdottoById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Prodotto updateProdotto(Prodotto existingProdotto) {
        return repository.save(existingProdotto);
    }

    @Override
    public void deleteProdottoById(Long id) {
        repository.deleteById(id);
    }
}
