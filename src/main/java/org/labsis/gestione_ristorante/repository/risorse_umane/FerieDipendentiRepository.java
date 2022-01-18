package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.FerieDipendenti;
import org.labsis.gestione_ristorante.entity.risorse_umane.FerieDipendentiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: Documentazione
 */

@Repository("ferieDipendentiRepository")
public interface FerieDipendentiRepository extends JpaRepository<FerieDipendenti, FerieDipendentiKey>, CustomFerieDipendentiRepository {

    // TODO: da implementare
}