package org.labsis.gestione_ristorante.repository.gestione_pagamenti;

import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OS;
import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OSkey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("rosRepository")
public interface R_OSRepository extends JpaRepository<R_OS, R_OSkey>, CustomR_OSRepository {

    Optional<R_OS> findR_OSById(R_OSkey id);

}