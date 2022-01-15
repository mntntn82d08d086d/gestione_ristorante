package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;

/**
 * TODO: Documentazione
 */

public interface AziendaConvenzioneService {

    AziendaConvenzione getAziendaConvenzioneByNomeAzienda(String nomeAzienda);

    AziendaConvenzione saveAziendaConvenzione(AziendaConvenzione aziendaConvenzione);

}
