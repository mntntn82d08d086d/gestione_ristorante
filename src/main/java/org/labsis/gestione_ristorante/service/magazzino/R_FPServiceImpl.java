package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.repository.magazzino.R_FPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service
public class R_FPServiceImpl implements R_FPService {

    @Autowired
    private R_FPRepository repository;

    @Override
    public List<R_FP> getAllForniture() {
        return repository.findAll();
    }

    @Override
    public Optional<R_FP> getFornituraByProdottoId(Long id) {
        return repository.findR_FPByProdottoId(id);
    }

    @Override
    public List<R_FP> getFornituraByFornitoreId(Long id) {
        return repository.findR_FPByFornitoreId(id);
    }

    @Override
    public Integer countFornitureByFornitoreId(Long id) {
        return repository.countFornitureByFornitoreId(id);
    }

    @Override
    public R_FP saveFornitura(R_FP fornitura) {
        return null;
        // TODO: da implementare
    }

    @Override
    public R_FP updateFornitura(R_FP fornitura) {
        return null;
        // TODO: da implementare
    }

    @Override
    public void deleteFornitura(Long id) {
        // TODO: da implementare
    }
}
