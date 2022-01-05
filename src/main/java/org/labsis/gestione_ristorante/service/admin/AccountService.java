package org.labsis.gestione_ristorante.service.admin;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.Role;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface AccountService {

    List<Account> getAllAccount();

    Account saveAccount(Account account);

    void saveAccountRole(Long id, Role role);

    Account getAccountById(Long id);

    Account updateAccount(Account account);

    Role updateAccountRole(Long id, Role role);

}
