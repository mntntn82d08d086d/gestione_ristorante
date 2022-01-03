package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.service.common.ContattoService;
import org.labsis.gestione_ristorante.service.magazzino.FornitoreService;
import org.labsis.gestione_ristorante.service.magazzino.R_FPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Documentazione
 */

@Controller
public class FornitoreController {

    @Autowired
    private FornitoreService service;

    @Autowired
    private ContattoService contattoService;

    @Autowired
    private R_FPService relazioniFpService;

    @GetMapping(value = "/magazzino/fornitori")
    public String getAllFornitori(Model model) {
        Map<Fornitore, Integer> map = new HashMap<>();
        List<Fornitore> fornitori = service.getAllFornitori();
        for(Fornitore f : fornitori) {
            Integer countForniture = relazioniFpService.countFornitureByFornitoreId(f.getId());
            map.put(f,countForniture);
        }
        model.addAttribute("fornitori", map);
        return "magazzino/fornitori";
    }

    @GetMapping("/magazzino/fornitori/new")
    public String createFornitore(Model model) {

        // create fornitore object to hold fornitore form data
        Fornitore fornitore = new Fornitore();
        model.addAttribute("fornitore", fornitore);
        return "magazzino/create_fornitore";
    }

    @PostMapping("/magazzino/fornitori/new")
    public String saveFornitore(@ModelAttribute("fornitore") Fornitore fornitore) {
        service.saveFornitore(fornitore);
        return "redirect:/magazzino/fornitori";
    }

    @GetMapping("/magazzino/fornitori/edit/{id}")
    public String editFornitore(@PathVariable("id") Long id, Model model) {
        Fornitore fornitore = service.getFornitoreById(id);
        model.addAttribute("fornitore", fornitore);
        return "magazzino/edit_fornitore";
    }

    @PostMapping("/magazzino/fornitori/edit/{id}")
    public String updateFornitore(@PathVariable Long id,
                                  @ModelAttribute("fornitore") Fornitore fornitore,
                                  Model model) {
        // get fornitore from database by id
        Fornitore existingFornitore = service.getFornitoreById(id);
        existingFornitore.setPiva(fornitore.getPiva());
        existingFornitore.setNomeAzienda(fornitore.getNomeAzienda());
        existingFornitore.setSedeLegale(fornitore.getSedeLegale());
        existingFornitore.setCitta(fornitore.getCitta());

        // save updated fornitore object
        service.updateFornitore(existingFornitore);
        return "redirect:/magazzino/fornitori";
    }

    @GetMapping("/magazzino/fornitori/edit/{id}/new_contatto")
    public String editFornitoreContatti(@PathVariable("id") Long id, Model model) {
        Fornitore fornitore = service.getFornitoreById(id);
        Contatto contatto = new Contatto();
        String tipologia = Contatto.EnumTipologia.NS.toString();
        String suffix = Contatto.EnumSuffix.NS.toString();
        model.addAttribute("fornitore", fornitore);
        model.addAttribute("contatto", contatto);
        model.addAttribute("tipologia", tipologia);
        model.addAttribute("suffix", suffix);
        return "magazzino/fornitore_nuovo_contatto";
    }

    @PostMapping("/magazzino/fornitori/{id}/update_contatto")
    public String addContattoFornitore(@PathVariable Long id,
                                  @ModelAttribute("fornitore") Fornitore fornitore,
                                  @ModelAttribute("contatto") Contatto contatto,
                                  Model model) {
        // get fornitore from database by id
        Fornitore existingFornitore = service.getFornitoreById(id);
        contattoService.saveContatto(contatto);
        existingFornitore.addContatto(contatto);

        // save updated fornitore object
        service.updateFornitore(existingFornitore);
        return "redirect:/magazzino/fornitori";
    }

    @GetMapping("/magazzino/fornitori/delete/{id}")
    public String deleteFornitoreById(@PathVariable Long id) {
        service.deleteFornitoreById(id);
        return "redirect:/magazzino/fornitori";
    }

    // TODO: da rivedere l'uso
    @GetMapping("/magazzino/fornitori/details/{id}")
    public String fornitoreDetails(@PathVariable("id") Long id, Model model) {
        Fornitore fornitore = service.getFornitoreById(id);
        model.addAttribute("fornitore", fornitore);
        return "magazzino/fornitore_details";
    }
}
