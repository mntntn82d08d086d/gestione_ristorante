package org.labsis.gestione_ristorante.service.gestione_pagamenti;

import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OS;
import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OSkey;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface R_OSService {

    Optional<R_OS> getR_OSById(R_OSkey id);

    Optional<R_OS> saveR_OS(R_OS ros);

    Optional<R_OS> updateR_OS(R_OS ros, R_OSkey id);

    Optional<R_OS> deleteR_OSByKey(R_OSkey id);

}
