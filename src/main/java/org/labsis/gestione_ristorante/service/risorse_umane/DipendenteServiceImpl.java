package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.labsis.gestione_ristorante.repository.risorse_umane.DipendenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("dipendenteService")
@Transactional(readOnly = true)
public class DipendenteServiceImpl implements DipendenteService {

    private final DipendenteRepository dipendenteRepository;

    public DipendenteServiceImpl(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    @Override
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    @Override
    public Optional<Dipendente> getDipendenteByCodiceFiscale(String codiceFiscale) {
        return dipendenteRepository.findDipendenteByCodiceFiscale(codiceFiscale);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Dipendente> saveDipendente(Dipendente dipendente) {
        return dipendenteRepository.saveDipendente(dipendente);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Dipendente> updateDipendente(Dipendente dipendente, String codiceFiscale) {
        return dipendenteRepository.updateDipendente(dipendente, codiceFiscale);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<Dipendente> deleteDipendenteByCodiceFiscale(String codiceFiscale) {
        return dipendenteRepository.deleteDipendenteByCodiceFiscale(codiceFiscale);
    }
}
