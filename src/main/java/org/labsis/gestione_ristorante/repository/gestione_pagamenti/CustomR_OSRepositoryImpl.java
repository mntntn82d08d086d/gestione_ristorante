package org.labsis.gestione_ristorante.repository.gestione_pagamenti;

import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OS;
import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OSkey;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomR_OSRepositoryImpl implements CustomR_OSRepository {

    private final EntityManager entityManager;

    public CustomR_OSRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<R_OS> saveR_OS(R_OS ros) {
        Optional<R_OS> ret = Optional.empty();
        R_OS r = entityManager.find(R_OS.class, ros.getId());
        if(r == null) {
            entityManager.persist(ros);
            ret = Optional.of(ros);
        }
        return ret;
    }

    @Override
    public Optional<R_OS> updateR_OS(R_OS ros, R_OSkey id) {
        Optional<R_OS> ret = Optional.empty();
        R_OS existingROS = entityManager.find(R_OS.class, id);
        if(existingROS != null) {
            entityManager.remove(existingROS);
            entityManager.flush();
            existingROS.setId(ros.getId());
            existingROS.setOrdine(ros.getOrdine());
            existingROS.setSocio(ros.getSocio());
            existingROS.setDataEvasione(ros.getDataEvasione());
            entityManager.persist(existingROS);
            ret = Optional.of(existingROS);
        }
        return ret;
    }

    @Override
    public Optional<R_OS> deleteR_OSByKey(R_OSkey id) {
        Optional<R_OS> ret = Optional.empty();
        R_OS r = entityManager.find(R_OS.class, id);
        if(r != null) {
            entityManager.remove(r);
            ret = Optional.of(r);
        }
        return ret;
    }
}
