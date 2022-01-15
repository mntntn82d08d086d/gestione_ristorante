package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: Documentazione
 */

@Repository
public interface AziendaConvenzioneRepository extends JpaRepository<AziendaConvenzione, String> {

    AziendaConvenzione findAziendaConvenzioneByNomeAzienda(String nomeAzienda);
}