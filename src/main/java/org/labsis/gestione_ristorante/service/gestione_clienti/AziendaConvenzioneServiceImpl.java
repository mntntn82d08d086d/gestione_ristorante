package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;
import org.labsis.gestione_ristorante.repository.gestione_cliente.AziendaConvenzioneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Service("aziendaConvenzioneService")
@Transactional(readOnly = true)
public class AziendaConvenzioneServiceImpl implements AziendaConvenzioneService {

    private final AziendaConvenzioneRepository aziendaConvenzioneRepository;

    public AziendaConvenzioneServiceImpl(AziendaConvenzioneRepository aziendaConvenzioneRepository) {
        this.aziendaConvenzioneRepository = aziendaConvenzioneRepository;
    }

    @Override
    public Optional<AziendaConvenzione> getAziendaConvenzioneByNomeAzienda(String nomeAzienda) {
        return aziendaConvenzioneRepository.findAziendaConvenzioneByNomeAzienda(nomeAzienda);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<AziendaConvenzione> saveAziendaConvenzione(AziendaConvenzione aziendaConvenzione) {
        return aziendaConvenzioneRepository.saveAziendaConvenzione(aziendaConvenzione);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<AziendaConvenzione> updateAziendaConvenzione(AziendaConvenzione aziendaConvenzione, String piva) {
        return aziendaConvenzioneRepository.updateAziendaConvenzione(aziendaConvenzione, piva);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Optional<AziendaConvenzione> deleteAziendaConvenzione(String piva) {
        return aziendaConvenzioneRepository.deleteAziendaConvenzione(piva);
    }
}
