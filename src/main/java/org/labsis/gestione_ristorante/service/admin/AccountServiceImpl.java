package org.labsis.gestione_ristorante.service.admin;

import org.labsis.gestione_ristorante.repository.admin.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: Documentazione
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

}
