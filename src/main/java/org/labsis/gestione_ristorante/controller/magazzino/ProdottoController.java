package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.service.magazzino.ProdottoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Controller
@RequestMapping("/magazzino")
public class ProdottoController {

    private final ProdottoService prodottoService;

    private static Integer flag;

    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
        flag = 0;
    }

    @GetMapping("/prodotti")
    public String getAllProdotti(Model model) {
        model.addAttribute("prodotti", prodottoService.getAllProdotto());
        model.addAttribute("obj", flag);
        return "magazzino/prodotti";
    }

    @GetMapping("/prodotti/new")
    public String createProdotto(Model model) {
        Prodotto prodotto = new Prodotto();
        model.addAttribute("prodotto", prodotto);
        return "magazzino/create_prodotto";
    }

    @PostMapping("/prodotti/new")
    public String saveProdotto(@ModelAttribute("prodotto") Prodotto prodotto, Model model) {
        Optional<Prodotto> obj = prodottoService.saveProdotto(prodotto);
        flag = 0; //caso vuoto
        if (obj.isEmpty())
            flag = 1;
        model.addAttribute("obj", flag);
        return "redirect:/magazzino/prodotti";
    }

    @GetMapping("/prodotti/edit/{id}")
    public String editProdotto(@PathVariable("id") Long id, Model model) {
        // TODO: da rivedere
        Prodotto prodotto = prodottoService.getProdottoById(id).get();
        model.addAttribute("prodotto", prodotto);
        return "magazzino/edit_prodotto";
    }

    @PostMapping("/prodotti/edit/{id}")
    public String updateFornitore(@PathVariable Long id,
                                  @ModelAttribute("prodotti") Prodotto prodotto,
                                  Model model) {
        Optional<Prodotto> opt = prodottoService.getProdottoById(id);
        if(opt.isPresent()) {
            Prodotto existingProdotto = opt.get();
            existingProdotto.setNome(prodotto.getNome());
            existingProdotto.setTipologia(prodotto.getTipologia());
            existingProdotto.setMarca(prodotto.getMarca());
            prodottoService.updateProdotto(existingProdotto, id);
        }
        return "redirect:/magazzino/prodotti";
    }

    @GetMapping("/prodotti/delete/{id}")
    public String deleteFornitori(@PathVariable Long id) {
        prodottoService.deleteProdottoById(id);
        return "redirect:/magazzino/prodotti";
    }
}
