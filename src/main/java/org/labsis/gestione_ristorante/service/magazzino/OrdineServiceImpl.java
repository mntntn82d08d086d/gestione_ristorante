package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.repository.magazzino.OrdineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("ordineService")
@Transactional(readOnly = true)
public class OrdineServiceImpl implements OrdineService {

    private final OrdineRepository ordineRepository;

    public OrdineServiceImpl(OrdineRepository ordineRepository) {
        this.ordineRepository = ordineRepository;
    }

    public List<Ordine> getAllOrdine() {
        return ordineRepository.findAll();
    }

    @Override
    public List<Prodotto> getAllProdottiInOrdine(long id) {
        return ordineRepository.findAllProdottiInOrdine(id);
    }

    @Override
    public Optional<Ordine> getOrdineById(Long id) {
        return ordineRepository.findOrdineById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Ordine> saveOrdine(Ordine ordine) {
        return ordineRepository.saveOrdine(ordine);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Ordine> updateOrdine(Ordine ordine, Long id) {
        return ordineRepository.updateOrdine(ordine, id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Ordine> deleteOrdineById(Long id) {
        return ordineRepository.deleteOrdineById(id);
    }
}
