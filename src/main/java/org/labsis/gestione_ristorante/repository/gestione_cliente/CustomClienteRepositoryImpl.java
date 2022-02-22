package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Cliente;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomClienteRepositoryImpl implements CustomClienteRepository {

    private final EntityManager entityManager;

    public CustomClienteRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Cliente> saveCliente(Cliente cliente) {
        Optional<Cliente> ret = Optional.empty();
        Cliente c = entityManager.find(Cliente.class, cliente.getCodiceFiscale());
        if(c == null) {
            entityManager.persist(cliente);
            ret = Optional.of(cliente);
        }
        return ret;
    }

    @Override
    public Optional<Cliente> updateCliente(Cliente cliente, String codiceFiscale) {
        Optional<Cliente> ret = Optional.empty();
        Cliente existingCliente = entityManager.find(Cliente.class, codiceFiscale);
        if(existingCliente != null) {
            entityManager.remove(existingCliente);
            entityManager.flush();
            existingCliente.setCodiceFiscale(cliente.getCodiceFiscale());
            existingCliente.setNome(cliente.getNome());
            existingCliente.setCognome(cliente.getCognome());
            existingCliente.setDataDiNascita(cliente.getDataDiNascita());
            existingCliente.setIndirizzo(cliente.getIndirizzo());
            existingCliente.setCitta(cliente.getCitta());
            existingCliente.setAccount(cliente.getAccount());
            entityManager.persist(existingCliente);
            ret = Optional.of(existingCliente);
        }
        return ret;
    }

    @Override
    public Optional<Cliente> deleteClienteByCodiceFiscale(String codiceFiscale) {
        Optional<Cliente> ret = Optional.empty();
        Cliente c = entityManager.find(Cliente.class, codiceFiscale);
        if(c != null) {
            entityManager.remove(c);
            ret = Optional.of(c);
        }
        return ret;
    }
}
