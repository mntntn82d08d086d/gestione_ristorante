package org.labsis.gestione_ristorante.repository.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Component
public class CustomContattoRepositoryImpl implements CustomContattoRepository {

    private final EntityManager entityManager;

    public CustomContattoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Contatto> saveContatto(Contatto contatto) {
        Optional<Contatto> ret = Optional.empty();
        try {
            // find di entityManager
            TypedQuery<Contatto> query = entityManager.createQuery("SELECT c FROM Contatto c WHERE c.contatto = ?1", Contatto.class);
            Contatto existingContatto = query.setParameter(1, contatto.getContatto()).getSingleResult();
            if(existingContatto != null)
                ret = Optional.of(existingContatto);
        } catch (NoResultException e) {
            entityManager.persist(contatto);
            entityManager.flush();
            ret = Optional.of(contatto);
        }
        return ret;
    }

    @Override
    public Optional<Contatto> updateContatto(Contatto contatto, Long id) {
        Optional<Contatto> ret = Optional.empty();
        Contatto existingContatto = entityManager.find(Contatto.class, id);
        if (existingContatto != null) {
            //existingContatto.setId(contatto.getId());
            existingContatto.setTipologia(contatto.getTipologia());
            existingContatto.setSuffix(contatto.getSuffix());
            existingContatto.setContatto(contatto.getContatto());
            entityManager.persist(existingContatto);
            ret = Optional.of(existingContatto);
        }
        return ret;
    }

    @Override
    public Optional<Contatto> deleteContattoById(Long id) {
        Optional<Contatto> ret = Optional.empty();
        Contatto c = entityManager.find(Contatto.class, id);
        if (c != null) {
            entityManager.remove(c);
            ret = Optional.of(c);
        }
        return ret;
    }
}
