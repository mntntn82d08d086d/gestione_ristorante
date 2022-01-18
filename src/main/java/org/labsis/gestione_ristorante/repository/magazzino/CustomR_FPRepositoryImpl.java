package org.labsis.gestione_ristorante.repository.magazzino;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class CustomR_FPRepositoryImpl implements CustomR_FPRepository {

    private final EntityManager entityManager;

    public CustomR_FPRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // TODO: da implementare
}
