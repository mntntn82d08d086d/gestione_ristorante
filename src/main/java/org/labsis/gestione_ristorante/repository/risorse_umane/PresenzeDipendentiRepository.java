package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.PresenzeDipendenti;
import org.labsis.gestione_ristorante.entity.risorse_umane.PrezenzeDipendenteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: Documentazione
 */

@Repository
public interface PresenzeDipendentiRepository extends JpaRepository<PresenzeDipendenti, PrezenzeDipendenteKey> {


}