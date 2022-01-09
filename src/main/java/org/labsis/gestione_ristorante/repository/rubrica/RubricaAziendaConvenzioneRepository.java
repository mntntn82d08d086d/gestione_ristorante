package org.labsis.gestione_ristorante.repository.rubrica;

import org.labsis.gestione_ristorante.entity.rubrica.RubricaAziendaConvenzione;
import org.labsis.gestione_ristorante.entity.rubrica.RubricaAziendaConvenzioneKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaAziendaConvenzioneRepository extends JpaRepository<RubricaAziendaConvenzione, RubricaAziendaConvenzioneKey> {


}