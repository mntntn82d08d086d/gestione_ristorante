package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;
import org.labsis.gestione_ristorante.repository.gestione_cliente.AziendaConvenzioneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("aziendaConvenzioneService")
@Transactional(readOnly = true)
public class AziendaConvenzioneServiceImpl implements AziendaConvenzioneService {

    private final AziendaConvenzioneRepository repository;

    public AziendaConvenzioneServiceImpl(AziendaConvenzioneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<AziendaConvenzione> getAziendaConvenzioneByNomeAzienda(String nomeAzienda) {
        return repository.findAziendaConvenzioneByNomeAzienda(nomeAzienda);
    }

    @Override
    public AziendaConvenzione saveAziendaConvenzione(AziendaConvenzione aziendaConvenzione) {
        // TODO: da implementare
        return repository.save(aziendaConvenzione);
    }
}
