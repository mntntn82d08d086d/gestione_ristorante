package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.service.gestione_clienti.AziendaConvenzioneService;
import org.springframework.stereotype.Controller;

/**
 * TODO: Documentazione
 */

@Controller
public class AziendaConvenzioneController {

    private final AziendaConvenzioneService aziendaConvenzioneService;

    public AziendaConvenzioneController(AziendaConvenzioneService aziendaConvenzioneService) {
        this.aziendaConvenzioneService = aziendaConvenzioneService;
    }
}
