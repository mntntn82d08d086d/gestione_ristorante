package org.labsis.gestione_ristorante.repository.common;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomContattoRepositoryImpl implements CustomContattoRepository {

    @Autowired
    private final EntityManager entityManager;

    @Override
    public Optional<Contatto> saveContatto(Contatto contatto) {
        Optional<Contatto> ret = Optional.empty();
        Contatto c = entityManager.find(Contatto.class, contatto.getId());
        if(c == null) {
            entityManager.persist(contatto);
            ret = Optional.of(contatto);
        }
        return ret;
    }

    @Override
    public Optional<Contatto> updateContatto(Contatto contatto, Long id) {
        Optional<Contatto> ret = Optional.empty();
        Contatto existingContatto = entityManager.find(Contatto.class, id);
        if(existingContatto != null) {
            entityManager.remove(existingContatto);
            entityManager.flush();
            existingContatto.setId(contatto.getId());
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
        if(c != null) {
            entityManager.remove(c);
            ret = Optional.of(c);
        }
        return ret;
    }
}
