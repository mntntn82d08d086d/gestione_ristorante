package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.service.magazzino.FornitoreService;
import org.labsis.gestione_ristorante.service.magazzino.ProdottoService;
import org.labsis.gestione_ristorante.service.magazzino.R_FPService;
import org.labsis.gestione_ristorante.service.magazzino.R_FPServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Controller
@RequestMapping("/magazzino")
public class R_FPController {

    private final R_FPService rfpService;

    private final ProdottoService prodottoService;

    private final FornitoreService fornitoreService;

    public R_FPController(R_FPServiceImpl rfpService, ProdottoService prodottoService, FornitoreService fornitoreService) {
        this.rfpService = rfpService;
        this.prodottoService = prodottoService;
        this.fornitoreService = fornitoreService;
    }

    @GetMapping("/forniture")
    public String getAllForniture(Model model) {
        List<R_FP> forniture = rfpService.getAllForniture();
        model.addAttribute("forniture", forniture);
        return "magazzino/forniture";
    }

    // TODO: da rivedere l'uso e la presentazione
    @GetMapping("/forniture/prodotto/{id}")
    public String getFornituraProdottoById(@PathVariable("id") Long id,
                                           Model model) {
        //Prodotto prodotto = prodottoService.getProdottoById(id);
        Optional<R_FP> fornitura = rfpService.getFornituraByProdottoId(id);
        model.addAttribute("fornitura", fornitura);
        if(fornitura.isPresent()) {
            Fornitore fornitore = fornitura.get().getFornitore();
            Prodotto prodotto = fornitura.get().getProdotto();
            model.addAttribute("fornitore", fornitore);
            model.addAttribute("prodotto", prodotto);
        }
        return "magazzino/fornitura_prodotto";
    }

    @GetMapping("/forniture/fornitore/{id}")
    public String getFornituraFornitoreById(@PathVariable("id") String id, Model model) {
        List<R_FP> fornitureFornitore = rfpService.getFornituraByFornitorePiva(id);
        model.addAttribute("fornitore_id", id);
        model.addAttribute("forniture", fornitureFornitore);
        return "magazzino/forniture_fornitore";
    }

    // TODO: da implementare POST
    // /magazzino/forniture/new

    // TODO: da implementare
    @GetMapping("/forniture/fornitore/{id}/new")
    public String createFornituraFornitore(@PathVariable("id") String id, Model model) {
        Optional<Fornitore> opt = fornitoreService.getFornitoreByPiva(id);
        Fornitore fornitore = opt.get();
        model.addAttribute("fornitore", fornitore);
        return "magazzino/create_fornitura_fornitore";
    }
}
