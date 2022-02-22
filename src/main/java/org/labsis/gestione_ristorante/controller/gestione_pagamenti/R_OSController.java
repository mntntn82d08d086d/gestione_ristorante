package org.labsis.gestione_ristorante.controller.gestione_pagamenti;

import org.labsis.gestione_ristorante.service.gestione_pagamenti.R_OSService;
import org.springframework.stereotype.Controller;

/**
 * TODO: Documentazione
 */

@Controller
public class R_OSController {

    private final R_OSService rosService;

    public R_OSController(R_OSService rosService) {
        this.rosService = rosService;
    }
}
