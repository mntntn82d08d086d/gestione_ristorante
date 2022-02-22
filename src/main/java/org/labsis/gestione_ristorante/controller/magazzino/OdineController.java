package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.service.magazzino.OrdineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Controller
@RequestMapping("/magazzino")
public class OdineController {

    private static final String LISTA_ORDINI = "magazzino/ordini";
    private static final String CREATE_ORDINE = "magazzino/create_ordine";
    private static final String EDIT_ORDINE = "magazzino/edit_ordine";
    private static final String REDIRECT_LISTA_ORDINI = "redirect:/magazzino/ordini";

    private final OrdineService ordineService;

    public OdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @GetMapping("/ordini")
    public String getAllOrdini(Model model) {
        List<Ordine> ordini = ordineService.getAllOrdine();
        model.addAttribute("ordini", ordini);
        return LISTA_ORDINI;
    }

    @GetMapping("/ordini/new")
    public String createOrdine(Model model) {
        Ordine ordine = new Ordine();
        model.addAttribute("ordine", ordine);
        return CREATE_ORDINE;
    }

    /**
     * @param ordine
     * @param model
     * @return
     */
    @PostMapping("/ordini/new")
    public String saveOrdine(@ModelAttribute("ordine") Ordine ordine, Model model) {
        ordineService.saveOrdine(ordine);
        return REDIRECT_LISTA_ORDINI;
    }

    @GetMapping("/ordini/edit/{id}")
    public String editOrdine(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ordine", ordineService.getOrdineById(id).get());
        return EDIT_ORDINE;
    }

    @PutMapping("/ordini/edit/{id}")
    public String updateOrdine(@PathVariable("id") Long id, @ModelAttribute("ordine") Ordine ordine, Model model) {
        ordineService.updateOrdine(ordine, id);
        return REDIRECT_LISTA_ORDINI;
    }

    @DeleteMapping("/ordini/delete/{id}")
    public String deleteOrdine(@PathVariable Long id) {
        ordineService.deleteOrdineById(id);
        return REDIRECT_LISTA_ORDINI;
    }
}
