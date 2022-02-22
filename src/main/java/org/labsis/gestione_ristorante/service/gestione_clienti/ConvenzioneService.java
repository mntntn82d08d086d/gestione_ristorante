package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public interface ConvenzioneService {

    Optional<Convenzione> getConvenzioneByCodiceConvenzione(String codiceConvenzione);

    List<Convenzione> getConvenzioneByDataStipula(Date dataStipula);

    //List<Convenzione> getConvenzioneByDataStipula_Month(Integer mese);

    Optional<Convenzione> saveConvenzione(Convenzione convenzione);

    Optional<Convenzione> updateConvenzione(Convenzione convenzione, Long id);

    Optional<Convenzione> deleteConvenzioneById(Long id);

}
