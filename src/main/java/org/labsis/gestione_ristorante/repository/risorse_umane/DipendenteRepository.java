package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("dipendenteRepository")
public interface DipendenteRepository extends JpaRepository<Dipendente, String>, CustomDipendenteRepository {

    Optional<Dipendente> findDipendenteByCodiceFiscale(String codiceFiscale);

}