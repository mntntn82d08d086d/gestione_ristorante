package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.repository.magazzino.FornitoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("fornitoreService")
public class FornitoreServiceImpl implements FornitoreService {

    private final FornitoreRepository fornitoreRepository;

    public FornitoreServiceImpl(FornitoreRepository fornitoreRepository) {
        this.fornitoreRepository = fornitoreRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Fornitore> getAllFornitori() {
        return fornitoreRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Fornitore> getFornitoreByPiva(String piva) {
        return fornitoreRepository.findFornitoreByPiva(piva);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {UnexpectedRollbackException.class, PersistenceException.class})
    @Override
    public Optional<Fornitore> saveFornitore(Fornitore fornitore) {
        Optional<Fornitore> ret;
        ret = fornitoreRepository.findFornitoreByNomeAzienda(fornitore.getNomeAzienda());
        if(ret.isEmpty()) {
            ret = fornitoreRepository.saveFornitore(fornitore);
        } else {
            ret = Optional.empty();
        }
        return ret;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {PersistenceException.class})
    @Override
    public Optional<Fornitore> updateFornitore(Fornitore fornitore, String piva) {
        return fornitoreRepository.updateFornitore(fornitore, piva);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {PersistenceException.class})
    @Override
    public Optional<Fornitore> deleteFornitoreByPiva(String piva) {
        return fornitoreRepository.deleteFornitoreByPiva(piva);
    }
}
