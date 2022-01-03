package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface DipendenteService {

    List<Dipendente> getAllDipendenti();

    Dipendente saveDipendente(Dipendente dipendente);

    Dipendente getDipendenteById(Long id);

    Dipendente updateDipendente(Dipendente dipendente);

    void deleteDipendenteById(Long id);

}
