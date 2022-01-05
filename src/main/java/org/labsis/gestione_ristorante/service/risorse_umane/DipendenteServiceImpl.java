package org.labsis.gestione_ristorante.service.risorse_umane;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.labsis.gestione_ristorante.repository.risorse_umane.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class DipendenteServiceImpl implements DipendenteService {

    @Autowired
    private final DipendenteRepository repository;

    @Override
    public List<Dipendente> getAllDipendenti() {
        return repository.findAll();
    }

    @Override
    public Dipendente saveDipendente(Dipendente dipendente) {
        return repository.save(dipendente);
    }

    @Override
    public Dipendente getDipendenteById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Dipendente updateDipendente(Dipendente dipendente) {
        return repository.save(dipendente);
    }

    @Override
    public void deleteDipendenteById(Long id) {
        repository.deleteById(id);
    }
}
