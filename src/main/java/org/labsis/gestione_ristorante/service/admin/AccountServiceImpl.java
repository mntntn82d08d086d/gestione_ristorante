package org.labsis.gestione_ristorante.service.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.AccountKey;
import org.labsis.gestione_ristorante.entity.admin.OldRole;
import org.labsis.gestione_ristorante.repository.admin.AccountRepository;
import org.labsis.gestione_ristorante.repository.admin.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService/*, UserDetailsService */{

    @Autowired
    private final AccountRepository repository;

    @Autowired
    private final RoleRepository roleRepository;

/*
    @Autowired
    private final PasswordEncoder passwordEncoder;
*/

    @Override
    public List<Account> getAllAccount() {
        return repository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
        //account.setPassword(passwordEncoder.encode(account.getPassword()));
        return repository.save(account);
    }

    // TODO: testare il metodo
/*
    @Override
    public void saveAccountRole(Long id, OldRole role) {
        Account account = repository.getById(id);
        account.addRole(role);
        roleRepository.save(role);
        repository.save(account);
    }
*/

    // TODO: implementare il metodo con Optional
    @Override
    public Account getAccountById(AccountKey id) {
        return repository.findById(id).get();
    }

    @Override
    public Account updateAccount(Account account) {
        return repository.save(account);
    }

    // TODO: valutare l'uso del metodo
    @Override
    public OldRole updateAccountRole(AccountKey id, OldRole oldRole) {
        return null;
    }

/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findAccountByUsername(username);
        if(account == null) {
            log.error("Account not found in database: {}", username);
            throw new UsernameNotFoundException("Account not found in database");
        } else {
            log.info("Account found in database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getOldRole()));
        });
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
    */
}
