package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.service.magazzino.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Controller
public class OdineController {

    @Autowired
    private OrdineService service;

    @GetMapping("/magazzino/ordini")
    public String getAllOrdini(Model model) {
        List<Ordine> ordini = service.getAllOrdine();
        model.addAttribute("ordini", ordini);
        return "magazzino/ordini";
    }

    @GetMapping("/magazzino/ordini/new")
    public String createOrdine(Model model) {
        Ordine ordine = new Ordine();
        model.addAttribute("ordine", ordine);
        return "magazzino/create_ordine";
    }

    @PostMapping("/magazzino/ordini/new")
    public String saveOrdine(@ModelAttribute("ordine") Ordine ordine) {
        service.saveOrdine(ordine);
        return "redirect:/magazzino/ordini";
    }

    @GetMapping("/magazzino/ordini/edit/{id}")
    public String editOrdine(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ordine", service.getOrdineById(id));
        return "magazzino/edit_ordine";
    }

    @PostMapping("/magazzino/ordini/edit/{id}")
    public String updateOrdine(@PathVariable("id") Long id,
                               @ModelAttribute("ordine") Ordine ordine,
                               Model model){
        Ordine existingOrdine = service.getOrdineById(id);
        existingOrdine.setCodiceOrdine(ordine.getCodiceOrdine());
        existingOrdine.setDataRichiesta(ordine.getDataRichiesta());
        existingOrdine.setOrdineEvaso(ordine.getOrdineEvaso());
        existingOrdine.setNota(ordine.getNota());

        service.saveOrdine(existingOrdine);
        return "redirect:/magazzino/ordini";
    }

    @GetMapping("/magazzino/ordini/delete/{id}")
    public String deleteOrdine(@PathVariable Long id) {
        service.deleteOrdineById(id);
        return "redirect:/magazzino/ordini";
    }
}