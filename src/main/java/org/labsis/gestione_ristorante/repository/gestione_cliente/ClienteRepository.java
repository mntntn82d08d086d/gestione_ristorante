package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: Documentazione
 */

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, String>, CustomClienteRepository {

    // TODO: da implementare

}