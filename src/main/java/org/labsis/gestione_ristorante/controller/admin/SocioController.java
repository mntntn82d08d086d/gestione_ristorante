package org.labsis.gestione_ristorante.controller.admin;

import org.labsis.gestione_ristorante.service.admin.SocioService;
import org.springframework.stereotype.Controller;

/**
 * TODO: Documentazione
 */

@Controller
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }
}
