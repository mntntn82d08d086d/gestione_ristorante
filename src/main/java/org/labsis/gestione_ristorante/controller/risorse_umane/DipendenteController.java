package org.labsis.gestione_ristorante.controller.risorse_umane;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.labsis.gestione_ristorante.service.risorse_umane.DipendenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//TODO: Documentazione

@Controller
@RequestMapping("/risorse_umane")
public class DipendenteController {

    private final DipendenteService dipendenteService;
    private final AccountService accountService;

    public DipendenteController(DipendenteService dipendenteService, AccountService accountService) {
        this.dipendenteService = dipendenteService;
        this.accountService = accountService;
    }

    @GetMapping("/dipendenti")
    public String getAllDipendenti(Model model) {
        List<Dipendente> dipendenti = dipendenteService.getAllDipendenti();
        model.addAttribute("dipendenti", dipendenti);
        return "risorse_umane/dipendenti";
    }

    @GetMapping("/dipendenti/new")
    public String createDipendente(Model model) {
        Dipendente dipendente = new Dipendente();
        Dipendente.EnumMansione mansioneObj = Dipendente.EnumMansione.NS;
        Account account = new Account();
        model.addAttribute("dipendente", dipendente);
        model.addAttribute("accountObj", account);
        model.addAttribute("mansioneObj", mansioneObj);
        return "risorse_umane/create_dipendente";
    }

    @PostMapping("/dipendenti/new")
    public String saveDipendente(@ModelAttribute("dipendente") Dipendente dipendente) {
        String username = "username";
        String passwd = "password";
        Account account = dipendente.getAccount();
        account.setUsername(username);
        account.setPassword(passwd);
        accountService.saveAccount(account);
        dipendenteService.saveDipendente(dipendente);
        return "redirect:/risorse_umane/dipendenti";
    }
}

