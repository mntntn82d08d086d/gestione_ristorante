package org.labsis.gestione_ristorante.repository.rubrica;

import org.labsis.gestione_ristorante.entity.rubrica.RubricaDipendente;
import org.labsis.gestione_ristorante.entity.rubrica.RubricaDipendenteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaDipendenteRepository extends JpaRepository<RubricaDipendente, RubricaDipendenteKey> {


}