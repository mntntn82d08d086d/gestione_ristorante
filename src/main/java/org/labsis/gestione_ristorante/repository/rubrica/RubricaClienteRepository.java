package org.labsis.gestione_ristorante.repository.rubrica;

import org.labsis.gestione_ristorante.entity.rubrica.RubricaCliente;
import org.labsis.gestione_ristorante.entity.rubrica.RubricaClienteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaClienteRepository extends JpaRepository<RubricaCliente, RubricaClienteKey> {


}