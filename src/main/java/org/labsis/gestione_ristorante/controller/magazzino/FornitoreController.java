package org.labsis.gestione_ristorante.controller.magazzino;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.service.common.ContattoService;
import org.labsis.gestione_ristorante.service.magazzino.FornitoreService;
import org.labsis.gestione_ristorante.service.magazzino.ProdottoService;
import org.labsis.gestione_ristorante.service.magazzino.R_FPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * TODO: Documentazione
 */

@Controller
@RequestMapping("/magazzino")
public class FornitoreController {

    private static final String LISTA_FORNITORI = "magazzino/fornitori";
    private static final String CREATE_FORNITORE = "magazzino/create_fornitore";
    private static final String EDIT_FORNITORE = "magazzino/edit_fornitore";
    private static final String CREATE_CONTATTO_FORNITORE = "magazzino/fornitore_nuovo_contatto";
    private static final String REDIRECT_LISTA_FORNITORI = "redirect:/magazzino/fornitori";

    private final FornitoreService fornitoreService;

    private final ContattoService contattoService;

    private final ProdottoService prodottoService;

    private final R_FPService rfpService;

    private static Integer flag;

    @Autowired
    public FornitoreController(FornitoreService fornitoreService, ContattoService contattoService, ProdottoService prodottoService, R_FPService rfpService) {
        this.fornitoreService = fornitoreService;
        this.contattoService = contattoService;
        this.prodottoService = prodottoService;
        this.rfpService = rfpService;
        flag = 0;
    }

    // TODO: da implementare la presentazione delle forniture
    @GetMapping(value = "/fornitori")
    public String getAllFornitori(Model model) {
        Map<Fornitore, Integer> map = new HashMap<>();
        List<Fornitore> fornitori = fornitoreService.getAllFornitori();
        for(Fornitore f : fornitori) {
            Integer countForniture = rfpService.countFornitureByFornitorePiva(f.getPiva());
            map.put(f,countForniture);
        }
        model.addAttribute("fornitori", map);
        model.addAttribute("obj", flag);
        return LISTA_FORNITORI;
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
        return CREATE_FORNITORE;
    }

    @PostMapping("/fornitori/new")
    public String saveFornitore(@ModelAttribute("fornitore") Fornitore fornitore, Model model
            /*, @ModelAttribute("prodotto") Prodotto prodotto, @ModelAttribute("fornitura") R_FP fornitura*/) {
        flag = 0; //caso vuoto
        Optional<Fornitore> obj = fornitoreService.saveFornitore(fornitore);
        if (obj.isEmpty())
            flag = 1;
        model.addAttribute("obj", flag);
        return REDIRECT_LISTA_FORNITORI;
    }
    // TODO: implementare l'eventualità di modifica fornitura
    @GetMapping("/fornitori/edit/{id}")
    public String editFornitore(@PathVariable("id") String id, Model model) {
        Optional<Fornitore> opt = fornitoreService.getFornitoreByPiva(id);
        Fornitore fornitore = null;
        if(opt.isPresent()) {
            fornitore = opt.get();
        }
        model.addAttribute("fornitore", fornitore);
        return EDIT_FORNITORE;
    }

    @PutMapping("/fornitori/edit/{id}")
    public String updateFornitore(@PathVariable("id") String id, @ModelAttribute("fornitore") Fornitore fornitore, Model model) {
        fornitoreService.updateFornitore(fornitore, id);
        return REDIRECT_LISTA_FORNITORI;
    }

    @GetMapping("/fornitori/edit/{id}/new_contatto")
    public String createFornitoreContatti(@PathVariable("id") String id, Model model) {
        Optional<Fornitore> opt = fornitoreService.getFornitoreByPiva(id);
        Fornitore fornitore = null;
        if(opt.isPresent()) {
            fornitore = opt.get();
        }
        Contatto contattoObj = new Contatto();
        Contatto.EnumTipologia tipologiaObj = Contatto.EnumTipologia.NS;
        Contatto.EnumSuffix suffixObj = Contatto.EnumSuffix.NS;
        model.addAttribute("fornitore", fornitore);
        model.addAttribute("contattoObj", contattoObj);
        model.addAttribute("tipologiaObj", tipologiaObj);
        model.addAttribute("suffixObj", suffixObj);
        return CREATE_CONTATTO_FORNITORE;
    }

    // TODO: da implementare
    @PostMapping("/fornitori/{id}/contatto")
    public String saveFornitoreContatto(@PathVariable("id") String id, @ModelAttribute("contattoObj") Contatto contatto, Model model){
        Optional<Fornitore> opt = fornitoreService.getFornitoreByPiva(id);
        Fornitore fornitore = null;
        boolean beenInserted = false;
        if(opt.isPresent()) {
            fornitore = opt.get();
            beenInserted = fornitore.addContatto(contatto);
        }
        // TODO: da implementare un messaggio se già presente
        if(beenInserted) {
            contattoService.saveContatto(contatto);
            fornitoreService.updateFornitore(fornitore, id);
        }
        return REDIRECT_LISTA_FORNITORI;
    }

    @GetMapping("/fornitori/edit/{id}/update_contatto/{contatto_id}")
    public String editContattoFornitore(@PathVariable("id") String id, @PathVariable("contatto_id") Long contatto_id, Model model) {
        Optional<Fornitore> optF = fornitoreService.getFornitoreByPiva(id);
        Fornitore existingFornitore = optF.get();
        Optional<Contatto> optC = contattoService.getContattoById(contatto_id);
        Contatto contatto = optC.get();
        // TODO: da rivedere
        Contatto.EnumTipologia tipologiaObj = Contatto.EnumTipologia.NS;
        Contatto.EnumSuffix suffixObj = Contatto.EnumSuffix.NS;
        model.addAttribute("tipologiaObj", tipologiaObj);
        model.addAttribute("suffixObj", suffixObj);
        model.addAttribute("fornitore", existingFornitore);
        model.addAttribute("contattoObj", contatto);
        return "magazzino/edit_fornitore_contatto";
    }

    // TODO: da rivedere
    @PostMapping("/fornitori/edit/{id}/update_contatto/{contatto_id}")
    public String updateContattoFornitore(@PathVariable("id") String id, @PathVariable("contatto_id") String str_contatto_id,
                                          @ModelAttribute("fornitore") Fornitore fornitore, @ModelAttribute("contatto") Contatto contatto, Model model) {
        Optional<Fornitore> opt = fornitoreService.getFornitoreByPiva(id);
        Fornitore existingFornitore = null;
        Long contatto_id = null;
        if(opt.isPresent()){
            existingFornitore = opt.get();
            contatto_id = Long.parseLong(str_contatto_id);
        }
        existingFornitore.updateContatto(contatto, contatto_id);
        contattoService.updateContatto(contatto, contatto_id);
        // TODO: da eliminare
        //contattoService.saveContatto(contatto);
        //fornitoreService.updateFornitore(existingFornitore, id);
        return REDIRECT_LISTA_FORNITORI;
    }

    // TODO: da implementare il verbo in HTML
    @DeleteMapping("/fornitori/delete/{id}/delete_contatto/{contatto_id}")
    public String deleteContattoFornitore(@PathVariable("id") String str_id, Model model) {
        Long id = Long.parseLong(str_id);

        contattoService.deleteContattoById(id);
        return REDIRECT_LISTA_FORNITORI;
    }

    @DeleteMapping("/fornitori/delete/{id}")
    public String deleteFornitoreById(@PathVariable("id") String id, Model model) {
        Optional<List<R_FP>> optionalFornitureFornitore = rfpService.deleteFornitureByFornitorePiva(id);
        List<R_FP> fornitureFornitore = optionalFornitureFornitore.get();
        List<Long> listProdottiId = new ArrayList<>();
        for(R_FP fornitura : fornitureFornitore) {
            listProdottiId.add(fornitura.getProdottoId());
        }
        // TODO: Da inserire il metodo deleteAllProdottoById(List longId)
        for(Long idProdotto : listProdottiId) {
            prodottoService.deleteProdottoById(idProdotto);
        }
        Optional<Fornitore> opt = fornitoreService.deleteFornitoreByPiva(id);
        // TODO: da implementare messaggio di cancellazione fornitore
        return REDIRECT_LISTA_FORNITORI;
    }
}