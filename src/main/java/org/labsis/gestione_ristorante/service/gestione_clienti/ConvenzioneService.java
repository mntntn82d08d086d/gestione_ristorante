package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public interface ConvenzioneService {

    Convenzione getConvenzioneByCodiceConvenzione(String codiceConvenzione);

    List<Convenzione> getConvenzioneByDataStipula(Date dataStipula);

    //List<Convenzione> getConvenzioneByDataStipula_Month(Integer mese);

    Convenzione saveConvenzione(Convenzione convenzione);
}
