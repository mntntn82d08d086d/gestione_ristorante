package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.labsis.gestione_ristorante.repository.gestione_cliente.ConvenzioneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service("convenzioneService")
@Transactional(readOnly = true)
public class ConvenzioneServiceImpl implements ConvenzioneService {

    private final ConvenzioneRepository convenzioneRepository;

    public ConvenzioneServiceImpl(ConvenzioneRepository convenzioneRepository) {
        this.convenzioneRepository = convenzioneRepository;
    }

    @Override
    public Optional<Convenzione> getConvenzioneByCodiceConvenzione(String codiceConvenzione) {
        return convenzioneRepository.findConvenzioneByCodiceConvenzione(codiceConvenzione);
    }

    @Override
    public List<Convenzione> getConvenzioneByDataStipula(Date dataStipula) {
        return convenzioneRepository.findConvenzioneByDataStipula(dataStipula);
    }

    // TODO: da implementare
/*
    @Override
    public List<Convenzione> getConvenzioneByDataStipula_Month(Integer mese) {
        return repository.findConvenzioneByDataStipula_Month(mese);
    }
*/

    @Override
    public Optional<Convenzione> saveConvenzione(Convenzione convenzione) {
        return convenzioneRepository.saveConvenzione(convenzione);
    }

    @Override
    public Optional<Convenzione> updateConvenzione(Convenzione convenzione, Long id) {
        return convenzioneRepository.updateConvenzione(convenzione, id);
    }

    @Override
    public Optional<Convenzione> deleteConvenzioneById(Long id) {
        return convenzioneRepository.deleteConvenzioneById(id);
    }
}
