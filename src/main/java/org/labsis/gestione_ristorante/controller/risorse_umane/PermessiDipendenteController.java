package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.service.risorse_umane.PermessiDipendenteService;
import org.springframework.stereotype.Controller;

/**
 * TODO: Documentazione
 */

@Controller
public class PermessiDipendenteController {

    private final PermessiDipendenteService permessiDipendenteService;

    public PermessiDipendenteController(PermessiDipendenteService permessiDipendenteService) {
        this.permessiDipendenteService = permessiDipendenteService;
    }
}
