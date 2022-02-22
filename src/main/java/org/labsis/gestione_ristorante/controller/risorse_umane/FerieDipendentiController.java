package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.service.risorse_umane.FerieDipendentiService;
import org.springframework.stereotype.Controller;

/**
 * TODO: Documentazione
 */

@Controller
public class FerieDipendentiController {

    private final FerieDipendentiService ferieDipendentiService;

    public FerieDipendentiController(FerieDipendentiService ferieDipendentiService) {
        this.ferieDipendentiService = ferieDipendentiService;
    }
}
