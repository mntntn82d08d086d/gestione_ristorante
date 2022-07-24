package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.entity.magazzino.R_FPKey;
import org.labsis.gestione_ristorante.repository.magazzino.R_FPRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("rfpService")
@Transactional(readOnly = true)
public class R_FPServiceImpl implements R_FPService {

    private final R_FPRepository rfpRepository;

    public R_FPServiceImpl(R_FPRepository rfpRepository) {
        this.rfpRepository = rfpRepository;
    }

    @Override
    public List<R_FP> getAllForniture() {
        return rfpRepository.findAll();
    }

    @Override
    public Optional<R_FP> getFornituraByProdottoId(Long id) {
        return rfpRepository.findR_FPByProdottoId(id);
    }

    @Override
    public List<R_FP> getFornituraByFornitorePiva(String piva) {
        return rfpRepository.findR_FPByFornitorePiva(piva);
    }

    @Override
    public Integer countFornitureByFornitorePiva(String piva) {
        return rfpRepository.countFornitureByFornitorePiva(piva);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<R_FP> saveFornitura(R_FP fornitura) {
        // TODO: da implementare
        return Optional.empty();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<R_FP> updateFornitura(R_FP fornitura, R_FPKey id) {
        // TODO: da implementare
        return Optional.empty();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<R_FP> deleteFornitura(R_FPKey id) {
        // TODO: da implementare
        return Optional.empty();
    }

    @Override
    public Optional<List<R_FP>> deleteFornitureByFornitorePiva(String piva) {
        List<R_FP> listaForniture = rfpRepository.findR_FPByFornitorePiva(piva);
        rfpRepository.deleteAll(listaForniture);
        rfpRepository.flush();
        return Optional.of(listaForniture);
    }

}
