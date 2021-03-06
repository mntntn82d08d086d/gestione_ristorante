package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface AziendaConvenzioneService {

    Optional<AziendaConvenzione> getAziendaConvenzioneByNomeAzienda(String nomeAzienda);

    Optional<AziendaConvenzione> saveAziendaConvenzione(AziendaConvenzione aziendaConvenzione);

    Optional<AziendaConvenzione> updateAziendaConvenzione(AziendaConvenzione aziendaConvenzione, String piva);

    Optional<AziendaConvenzione> deleteAziendaConvenzione(String piva);

}
