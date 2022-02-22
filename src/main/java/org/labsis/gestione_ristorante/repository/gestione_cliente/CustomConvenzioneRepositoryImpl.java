package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomConvenzioneRepositoryImpl implements CustomConvenzioneRepository {

    private final EntityManager entityManager;

    public CustomConvenzioneRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Convenzione> saveConvenzione(Convenzione convenzione) {
        Optional<Convenzione> ret = Optional.empty();
        Convenzione c = entityManager.find(Convenzione.class, convenzione.getId());
        if(c == null) {
            entityManager.persist(convenzione);
            ret = Optional.of(convenzione);
        }
        return ret;
    }

    @Override
    public Optional<Convenzione> updateConvenzione(Convenzione convenzione, Long id) {
        Optional<Convenzione> ret = Optional.empty();
        Convenzione existingConvenzione = entityManager.find(Convenzione.class, id);
        if(existingConvenzione != null) {
            entityManager.remove(existingConvenzione);
            entityManager.flush();
            existingConvenzione.setId(convenzione.getId());
            existingConvenzione.setCodiceConvenzione(convenzione.getCodiceConvenzione());
            existingConvenzione.setDataStipula(convenzione.getDataStipula());
            existingConvenzione.setSconto(convenzione.getSconto());
            entityManager.persist(existingConvenzione);
            ret = Optional.of(existingConvenzione);
        }
        return ret;
    }

    @Override
    public Optional<Convenzione> deleteConvenzioneById(Long id) {
        Optional<Convenzione> ret = Optional.empty();
        Convenzione c = entityManager.find(Convenzione.class, id);
        if(c != null) {
            entityManager.remove(c);
            ret = Optional.of(c);
        }
        return ret;
    }
}
