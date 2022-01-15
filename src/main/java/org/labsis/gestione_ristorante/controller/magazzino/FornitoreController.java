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
@RequestMapping("/magazzino")
public class FornitoreController {

    @Autowired
    private FornitoreService service;

    @Autowired
    private ContattoService contattoService;

    @Autowired
    private R_FPService rFpService;

    // TODO: da implementare la presentazione delle forniture
    @GetMapping(value = "/fornitori")
    public String getAllFornitori(Model model) {
        Map<Fornitore, Integer> map = new HashMap<>();
        List<Fornitore> fornitori = service.getAllFornitori();
        List<Contatto> contatti;
        for(Fornitore f : fornitori) {
            Integer countForniture = rFpService.countFornitureByFornitoreId(f.getPiva());
            map.put(f,countForniture);
        }
        model.addAttribute("fornitori", map);
        return "magazzino/fornitori";
    }

    // TODO: da implementare l'eventualità di aggiungere una fornitura
    @GetMapping("/fornitori/new")
    public String createFornitore(Model model) {
        Fornitore fornitore = new Fornitore();
/*
        Prodotto prodotto = new Prodotto();
        R_FP fornitura = new R_FP();
*/
        model.addAttribute("fornitore", fornitore);
/*
        model.addAttribute("prodotto", prodotto);
        model.addAttribute("fornitura", fornitura);
*/
        return "magazzino/create_fornitore";
    }

    @PostMapping("/fornitori/new")
    public String saveFornitore(@ModelAttribute("fornitore") Fornitore fornitore/*,
                                @ModelAttribute("prodotto") Prodotto prodotto,
                                @ModelAttribute("fornitura") R_FP fornitura*/) {
        service.saveFornitore(fornitore);
        return "redirect:/magazzino/fornitori";
    }

    // TODO: implementare l'eventualità di modifica fornitura
    @GetMapping("/fornitori/edit/{id}")
    public String editFornitore(@PathVariable("id") String id, Model model) {
        Fornitore fornitore = service.getFornitoreById(id);
        model.addAttribute("fornitore", fornitore);
        return "magazzino/edit_fornitore";
    }

    @PostMapping("/fornitori/edit/{id}")
    public String updateFornitore(@PathVariable String id,
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

    @GetMapping("/fornitori/edit/{id}/new_contatto")
    public String createFornitoreContatti(@PathVariable("id") String id, Model model) {
        Fornitore fornitore = service.getFornitoreById(id);
        Contatto contattoObj = new Contatto();
        Contatto.EnumTipologia tipologiaObj = Contatto.EnumTipologia.NS;
        Contatto.EnumSuffix suffixObj = Contatto.EnumSuffix.NS;
        model.addAttribute("fornitore", fornitore);
        model.addAttribute("contattoObj", contattoObj);
        model.addAttribute("tipologiaObj", tipologiaObj);
        model.addAttribute("suffixObj", suffixObj);
        return "magazzino/fornitore_nuovo_contatto";
    }

    // TODO: da implementare
    @PostMapping("/fornitori/{id}/contatto")
    public String saveFornitoreContatto(@PathVariable("id") String id,
                                        @ModelAttribute("contattoObj") Contatto contatto,
                                        Model model){
        Fornitore fornitore = service.getFornitoreById(id);
        fornitore.addContatto(contatto);
        contattoService.saveContatto(contatto);
        service.saveFornitore(fornitore);
        return "redirect:/magazzino/fornitori";
    }

    @PostMapping("/fornitori/{id}/update_contatto")
    public String addContattoFornitore(@PathVariable String id,
                                  @ModelAttribute("fornitore") Fornitore fornitore,
                                  @ModelAttribute("contatto") Contatto contatto,
                                  Model model) {
        // get fornitore from database by id
        Fornitore existingFornitore = service.getFornitoreById(id);
        contattoService.saveContatto(contatto);
        //existingFornitore.addContatto(contatto);

        // save updated fornitore object
        service.updateFornitore(existingFornitore);
        return "redirect:/magazzino/fornitori";
    }

    @GetMapping("/fornitori/delete/{id}")
    public String deleteFornitoreById(@PathVariable String id) {
        service.deleteFornitoreById(id);
        return "redirect:/magazzino/fornitori";
    }

    // TODO: da rivedere l'uso
    @GetMapping("/magazzino/fornitori/details/{id}")
    public String fornitoreDetails(@PathVariable("id") String id, Model model) {
        Fornitore fornitore = service.getFornitoreById(id);
        model.addAttribute("fornitore", fornitore);
        return "magazzino/fornitore_details";
    }
}
