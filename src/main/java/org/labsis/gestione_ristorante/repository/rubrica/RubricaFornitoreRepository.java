package org.labsis.gestione_ristorante.repository.rubrica;

import org.labsis.gestione_ristorante.entity.rubrica.RubricaFornitore;
import org.labsis.gestione_ristorante.entity.rubrica.RubricaFornitoreKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaFornitoreRepository extends JpaRepository<RubricaFornitore, RubricaFornitoreKey> {


}