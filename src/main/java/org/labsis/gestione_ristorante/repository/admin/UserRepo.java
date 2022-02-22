package org.labsis.gestione_ristorante.repository.admin;

import org.labsis.gestione_ristorante.entity.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
