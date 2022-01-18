package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomDipendenteRepository {

    Optional<Dipendente> saveDipendente(Dipendente dipendente);

    Optional<Dipendente> updateDipendente(Dipendente dipendente, String codiceFiscale);

    Optional<Dipendente> deleteDipendenteByCodiceFiscale(String codiceFiscale);
}
