package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("fornitoreRepository")
public interface FornitoreRepository extends JpaRepository<Fornitore, String>, CustomFornitoreRepository {

    Optional<Fornitore> findFornitoreByPiva(String piva);

    Optional<Fornitore> findFornitoreByNomeAzienda(String nomeAzienda);

}

