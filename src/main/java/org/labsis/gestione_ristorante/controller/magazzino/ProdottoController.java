package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.service.magazzino.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * TODO: Documentazione
 */

@Controller
public class ProdottoController {

    @Autowired
    private ProdottoService service;

    @GetMapping("/magazzino/prodotti")
    public String getAllProdotti(Model model) {
        model.addAttribute("prodotti", service.getAllProdotto());
        return "magazzino/prodotti";
    }

    @GetMapping("/magazzino/prodotti/new")
    public String createProdotto(Model model) {
        Prodotto prodotto = new Prodotto();
        model.addAttribute("prodotto", prodotto);
        return "magazzino/create_prodotto";
    }

    @PostMapping("/magazzino/prodotti/new")
    public String saveProdotto(@ModelAttribute("prodotto") Prodotto prodotto) {
        service.saveProdotto(prodotto);
        return "redirect:/magazzino/prodotti";
    }

    @GetMapping("/magazzino/prodotti/edit/{id}")
    public String editProdotto(@PathVariable("id") Long id, Model model) {
        Prodotto prodotto = service.getProdottoById(id);
        model.addAttribute("prodotto", prodotto);
        return "magazzino/edit_prodotto";
    }

    @PostMapping("/magazzino/prodotti/edit/{id}")
    public String updateFornitore(@PathVariable Long id,
                                  @ModelAttribute("prodotti") Prodotto prodotto,
                                  Model model) {
        Prodotto existingProdotto = service.getProdottoById(id);
        existingProdotto.setNome(prodotto.getNome());
        existingProdotto.setTipologia(prodotto.getTipologia());
        existingProdotto.setMarca(prodotto.getMarca());

        service.updateProdotto(existingProdotto);
        return "redirect:/magazzino/prodotti";
    }

    @GetMapping("/magazzino/prodotti/delete/{id}")
    public String deleteFornitori(@PathVariable Long id) {
        service.deleteProdottoById(id);
        return "redirect:/magazzino/prodotti";
    }
}
