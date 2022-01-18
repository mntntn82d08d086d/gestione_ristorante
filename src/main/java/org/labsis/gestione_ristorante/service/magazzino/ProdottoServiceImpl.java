package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.repository.magazzino.ProdottoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("prodottoService")
@Transactional(readOnly = true)
public class ProdottoServiceImpl implements ProdottoService {

    private final ProdottoRepository prodottoRepository;

    public ProdottoServiceImpl(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    @Override
    public List<Prodotto> getAllProdotto() {
        return prodottoRepository.findAll();
    }

    @Override
    public Optional<Prodotto> getProdottoById(Long id) {
        return prodottoRepository.findProdottoById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Prodotto> saveProdotto(Prodotto prodotto) {
        return prodottoRepository.saveProdotto(prodotto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Prodotto> updateProdotto(Prodotto prodotto, Long id) {
        return prodottoRepository.updateProdotto(prodotto, id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Prodotto> deleteProdottoById(Long id) {
        prodottoRepository.deleteById(id);
        return Optional.empty();
    }
}
