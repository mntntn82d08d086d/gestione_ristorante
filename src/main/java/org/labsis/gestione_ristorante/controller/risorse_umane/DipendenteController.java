package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.labsis.gestione_ristorante.service.risorse_umane.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Controller
public class DipendenteController {

    @Autowired
    private DipendenteService service;

    @GetMapping("/risorse_umane/dipendenti")
    public String getAllDipendenti(Model model) {
        List<Dipendente> dipendenti = service.getAllDipendenti();
        model.addAttribute("dipendenti", dipendenti);
        return "risorse_umane/dipendenti";
    }

    @GetMapping("/risorse_umane/dipendenti/new")
    public String createDipendente(Model model) {
        Dipendente dipendente = new Dipendente();
        model.addAttribute("dipendente", dipendente);
        return "risorse_umane/create_dipendente";
    }

    @PostMapping("/risorse_umane/dipendenti/new")
    public String saveDipendente(@ModelAttribute("dipendente") Dipendente dipendente) {
        service.saveDipendente(dipendente);
        return "redirect:/risorse_umane/dipendenti";
    }
}
