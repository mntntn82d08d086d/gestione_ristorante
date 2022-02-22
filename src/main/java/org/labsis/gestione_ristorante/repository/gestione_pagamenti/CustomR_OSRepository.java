package org.labsis.gestione_ristorante.repository.gestione_pagamenti;

import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OS;
import org.labsis.gestione_ristorante.entity.gestione_pagamenti.R_OSkey;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomR_OSRepository {

    Optional<R_OS> saveR_OS(R_OS ros);

    Optional<R_OS> updateR_OS(R_OS ros, R_OSkey id);

    Optional<R_OS> deleteR_OSByKey(R_OSkey id);

}
