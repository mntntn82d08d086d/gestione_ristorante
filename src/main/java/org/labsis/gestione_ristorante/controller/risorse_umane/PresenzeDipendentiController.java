package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.service.risorse_umane.PresenzeDipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * TODO: Documentazione
 */

@Controller
public class PresenzeDipendentiController {

    @Autowired
    private PresenzeDipendentiService service;
}
