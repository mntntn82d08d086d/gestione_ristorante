package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Cliente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomClienteRepository {

    Optional<Cliente> saveCliente(Cliente cliente);

    Optional<Cliente> updateCliente(Cliente cliente, String codiceFiscale);

    Optional<Cliente> deleteClienteByCodiceFiscale(String codiceFiscale);

}
