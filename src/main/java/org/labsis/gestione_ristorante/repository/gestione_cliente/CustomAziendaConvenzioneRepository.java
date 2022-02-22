package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomAziendaConvenzioneRepository {

    Optional<AziendaConvenzione> saveAziendaConvenzione(AziendaConvenzione aziendaConvenzione);

    Optional<AziendaConvenzione> updateAziendaConvenzione(AziendaConvenzione aziendaConvenzione, String piva);

    Optional<AziendaConvenzione> deleteAziendaConvenzione(String piva);

}
