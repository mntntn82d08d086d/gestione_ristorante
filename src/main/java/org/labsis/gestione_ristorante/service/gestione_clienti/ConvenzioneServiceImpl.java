package org.labsis.gestione_ristorante.service.gestione_clienti;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.labsis.gestione_ristorante.repository.gestione_cliente.ConvenzioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ConvenzioneServiceImpl implements ConvenzioneService {

    @Autowired
    private final ConvenzioneRepository repository;


    @Override
    public Convenzione getConvenzioneByCodiceConvenzione(String codiceConvenzione) {
        return repository.findConvenzioneByCodiceConvenzione(codiceConvenzione);
    }

    @Override
    public List<Convenzione> getConvenzioneByDataStipula(Date dataStipula) {
        return repository.findConvenzioneByDataStipula(dataStipula);
    }

/*
    @Override
    public List<Convenzione> getConvenzioneByDataStipula_Month(Integer mese) {
        return repository.findConvenzioneByDataStipula_Month(mese);
    }
*/

    @Override
    public Convenzione saveConvenzione(Convenzione convenzione) {
        return repository.save(convenzione);
    }
}
