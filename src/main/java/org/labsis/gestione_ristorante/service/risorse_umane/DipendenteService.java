package org.labsis.gestione_ristorante.service.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

public interface DipendenteService {

    List<Dipendente> getAllDipendenti();

    Optional<Dipendente> getDipendenteByCodiceFiscale(String codiceFiscale);

    Optional<Dipendente> saveDipendente(Dipendente dipendente);

    Optional<Dipendente> updateDipendente(Dipendente dipendente, String codiceFiscale);

    Optional<Dipendente> deleteDipendenteByCodiceFiscale(String codiceFiscale);

}
