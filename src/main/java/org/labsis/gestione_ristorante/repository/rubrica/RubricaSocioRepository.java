package org.labsis.gestione_ristorante.repository.rubrica;

import org.labsis.gestione_ristorante.entity.rubrica.RubricaSocio;
import org.labsis.gestione_ristorante.entity.rubrica.RubricaSocioKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaSocioRepository extends JpaRepository<RubricaSocio, RubricaSocioKey> {


}