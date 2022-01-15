package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;

import java.sql.Date;
import java.util.List;

public interface ConvenzioneService {

    Convenzione getConvenzioneByCodiceConvenzione(String codiceConvenzione);

    List<Convenzione> getConvenzioneByDataStipula(Date dataStipula);

    //List<Convenzione> getConvenzioneByDataStipula_Month(Integer mese);

    Convenzione saveConvenzione(Convenzione convenzione);
}
