package org.labsis.gestione_ristorante.controller.admin;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * TODO: Documentazione
 */

@Controller
//@RequestMapping("/api")
public class AccountController {

/*
    @Autowired
    private AccountService service;
*/

/*    @GetMapping("/users")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity.ok().body(service.getAllAccount());
    }

    @PostMapping("/user/save")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(service.saveAccount(account));
    }*/
}
