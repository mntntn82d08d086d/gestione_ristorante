package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.service.magazzino.FornitoreService;
import org.labsis.gestione_ristorante.service.magazzino.ProdottoService;
import org.labsis.gestione_ristorante.service.magazzino.R_FPServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Controller
public class R_FPController {

    @Autowired
    private R_FPServiceImpl service;

    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private FornitoreService fornitoreService;

    @GetMapping("/magazzino/forniture")
    public String getAllForniture(Model model) {
        List<R_FP> forniture = service.getAllForniture();
        model.addAttribute("forniture", forniture);
        return "magazzino/forniture";
    }

    // TODO: da rivedere l'uso e la presentazione
    @GetMapping("/magazzino/forniture/prodotto/{id}")
    public String getFornituraProdottoById(@PathVariable("id") Long id,
                                           Model model) {
        //Prodotto prodotto = prodottoService.getProdottoById(id);
        Optional<R_FP> fornitura = service.getFornituraByProdottoId(id);
        model.addAttribute("fornitura", fornitura);
        if(!fornitura.isEmpty()) {
            Fornitore fornitore = fornitura.get().getFornitore();
            Prodotto prodotto = fornitura.get().getProdotto();
            model.addAttribute("fornitore", fornitore);
            model.addAttribute("prodotto", prodotto);
        }
        return "magazzino/fornitura_prodotto";
    }

    @GetMapping("/magazzino/forniture/fornitore/{id}")
    public String getFornituraFornitoreById(@PathVariable("id") String id, Model model) {
        List<R_FP> fornitureFornitore = service.getFornituraByFornitoreId(id);
        model.addAttribute("fornitore_id", id);
        model.addAttribute("forniture", fornitureFornitore);
        return "magazzino/forniture_fornitore";
    }

    // TODO: da implementare
    // /magazzino/forniture/new

    // TODO: da implementare
    @GetMapping("/magazzino/forniture/fornitore/{id}/new")
    public String createFornituraFornitore(@PathVariable("id") String id, Model model) {
        Fornitore fornitore = fornitoreService.getFornitoreById(id);

        return "magazzino/create_fornitura_fornitore";
    }
}
