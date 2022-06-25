package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.labsis.gestione_ristorante.service.common.ContattoService;
import org.labsis.gestione_ristorante.service.risorse_umane.DipendenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//TODO: Documentazione


@Controller
@RequestMapping("/risorse_umane")
public class DipendenteController {

    private static final String LISTA_DIPENDENTI = "risorse_umane/dipendenti";
    private static final String CREATE_DIPENDENTE = "risorse_umane/create_dipendente";
    private static final String EDIT_DIPENDENTE = "risorse_umane/edit_dipendente";
    private static final String CREATE_CONTATTO_DIPENDENTI = "risorse_umane/dipendente_nuovo_contatto";
    private static final String REDIRECT_LISTA_DIPENDENTI = "redirect:/risorse_umane/dipendenti";

    private final DipendenteService dipendenteService;
    private final AccountService accountService;
    private final ContattoService contattoService;
    private static Integer flag;

    public DipendenteController(DipendenteService dipendenteService, AccountService accountService, ContattoService contattoService) {
        this.dipendenteService = dipendenteService;
        this.accountService = accountService;
        this.contattoService = contattoService;
    }
    @GetMapping("/dipendenti")
    public String getAllDipendenti(Model model) {
        List<Dipendente> dipendenti = dipendenteService.getAllDipendenti();
        model.addAttribute("dipendenti", dipendenti);
        model.addAttribute("obj", flag);
        return LISTA_DIPENDENTI;
    }

    @GetMapping("/dipendenti/new")
    public String createDipendente(Model model) {
        Dipendente dipendente = new Dipendente();
        Dipendente.EnumMansione mansioneObj = Dipendente.EnumMansione.NS;
        dipendente.setMansione(Dipendente.EnumMansione.NS.getMansione());
        //Account account = new Account();
        model.addAttribute("dipendente", dipendente);
        // TODO: da implementare
        //model.addAttribute("accountObj", account);
        model.addAttribute("mansioneObj", mansioneObj);
        return CREATE_DIPENDENTE;
    }

    @PostMapping("/dipendenti/new")
    public String saveDipendente(@ModelAttribute("dipendente") Dipendente dipendente) {
        String username = "username";
        String passwd = "password";
        Account account = dipendente.getAccount();
        account.setUsername(username);
        account.setPassword(passwd);
        accountService.saveAccount(account);
        Optional<Dipendente> obj = dipendenteService.saveDipendente(dipendente);
        flag = 0; //caso vuoto
        if (obj.isEmpty())
            flag = 1;
        //model.addAttribute("obj", flag);
        return REDIRECT_LISTA_DIPENDENTI;

    }


    // TODO: implementare l'eventualità di modifica fornitura
    @GetMapping("/dipendenti/edit/{id}")
    public String editDipendente(@PathVariable("id") String codiceFiscale, Model model) {
        Optional<Dipendente> opt = dipendenteService.getDipendenteByCodiceFiscale(codiceFiscale);
        Dipendente dipendente = null;
        Dipendente.EnumMansione mansione = null;
        if(opt.isPresent()) {
            dipendente = opt.get();
            mansione = Dipendente.EnumMansione.NS;
        }
        model.addAttribute("dipendente", dipendente);
        model.addAttribute("mansione", mansione);
        return EDIT_DIPENDENTE;
    }

    @PutMapping("/dipendenti/edit/{id}")
    public String updateDipendente(@PathVariable("id") String codiceFiscale, @ModelAttribute("dipendente") Dipendente dipendente) {
        String username = "username";
        String passwd = "password";
        Account account = dipendente.getAccount();
        account.setUsername(username);
        account.setPassword(passwd);
        accountService.updateAccount(account);

        dipendenteService.updateDipendente(dipendente, codiceFiscale);
        return REDIRECT_LISTA_DIPENDENTI;
    }

    @GetMapping("/dipendenti/edit/{id}/new_contatto")
    public String createDipendenteContatti(@PathVariable("id") String id, Model model) {
        Optional<Dipendente> opt = dipendenteService.getDipendenteByCodiceFiscale(id);
        Dipendente dipendente = null;
        if (opt.isPresent()) {
            dipendente = opt.get();
        }
        Contatto contattoObj = new Contatto();
        Contatto.EnumTipologia tipologiaObj = Contatto.EnumTipologia.NS;
        Contatto.EnumSuffix suffixObj = Contatto.EnumSuffix.NS;
        model.addAttribute("dipendente", dipendente);
        model.addAttribute("contattoObj", contattoObj);
        model.addAttribute("tipologiaObj", tipologiaObj);
        model.addAttribute("suffixObj", suffixObj);

        return CREATE_CONTATTO_DIPENDENTI;
    }

    // TODO: da implementare
    @PostMapping("/dipendenti/{id}/contatto")
    public String saveDipendenteContatto(@PathVariable("codiceFiscale") String codiceFiscale, @ModelAttribute("contattoObj") Contatto contatto, Model model){
        Optional<Dipendente> opt = dipendenteService.getDipendenteByCodiceFiscale(codiceFiscale);
        Dipendente dipendente= null;
        boolean beenInserted = false;
        if(opt.isPresent()) {
            dipendente = opt.get();
//            beenInserted = dipendente.addContatto(contatto);
        }
        // TODO: da implementare un messaggio se già presente
        if(beenInserted) {
            contattoService.saveContatto(contatto);
            dipendenteService.updateDipendente(dipendente,codiceFiscale);
        }
        return REDIRECT_LISTA_DIPENDENTI;
    }

    // TODO: da rivedere
    @PostMapping("/dipendenti/{id}/update_contatto")
    public String addContattoDipendente(@PathVariable String codiceFiscale, @ModelAttribute("dipendente") Dipendente dipendente, @ModelAttribute("contatto") Contatto contatto, Model model) {
        Optional<Dipendente> opt = dipendenteService.getDipendenteByCodiceFiscale(codiceFiscale);
        Dipendente existingDipendente = null;
        if (opt.isPresent()) {
            existingDipendente = opt.get();
        }
        contattoService.saveContatto(contatto);
        dipendenteService.updateDipendente(existingDipendente, codiceFiscale);
        return REDIRECT_LISTA_DIPENDENTI;
    }

    @DeleteMapping("/dipendenti/delete/{id}")
    public String deleteDipendenteByCodiceFiscale(@PathVariable("id") String codiceFiscale) {
        Optional<Dipendente> opt = dipendenteService.deleteDipendenteByCodiceFiscale(codiceFiscale);
        // TODO: da implementare messaggio di cancellazione fornitore
        return REDIRECT_LISTA_DIPENDENTI;
    }
}
