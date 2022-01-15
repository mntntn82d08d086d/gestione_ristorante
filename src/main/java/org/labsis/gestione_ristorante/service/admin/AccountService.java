package org.labsis.gestione_ristorante.service.admin;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.AccountKey;
import org.labsis.gestione_ristorante.entity.admin.OldRole;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface AccountService {

    List<Account> getAllAccount();

    Account saveAccount(Account account);

    //void saveAccountRole(Long id, OldRole role);

    Account getAccountById(AccountKey id);

    Account updateAccount(Account account);

    OldRole updateAccountRole(AccountKey id, OldRole oldRole);

}
