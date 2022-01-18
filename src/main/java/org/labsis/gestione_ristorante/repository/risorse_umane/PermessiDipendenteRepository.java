package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.PermessiDipendente;
import org.labsis.gestione_ristorante.entity.risorse_umane.PermessiDipendentiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: Documentazione
 */

@Repository("permessiDipendenteRepository")
public interface PermessiDipendenteRepository extends JpaRepository<PermessiDipendente, PermessiDipendentiKey>, CustomPermessiDipendentiRepository {

    // TODO: da implementare

}