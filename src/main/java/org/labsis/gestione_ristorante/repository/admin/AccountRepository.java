package org.labsis.gestione_ristorante.repository.admin;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.AccountKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO: Documentazione
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountKey> {

/*
    Account findAccountByUsername(String username);

    Account findAccountByEmail(String email);
*/

}