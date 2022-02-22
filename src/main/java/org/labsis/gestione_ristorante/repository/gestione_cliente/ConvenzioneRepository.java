package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("convenzioneRepository")
public interface ConvenzioneRepository extends JpaRepository<Convenzione, Long>, CustomConvenzioneRepository {

    Optional<Convenzione> findConvenzioneByCodiceConvenzione(String codiceConvenzione);

    List<Convenzione> findConvenzioneByDataStipula(Date dataStipula);

    //List<Convenzione> findConvenzioneByDataStipula_Month(Integer mese);
}