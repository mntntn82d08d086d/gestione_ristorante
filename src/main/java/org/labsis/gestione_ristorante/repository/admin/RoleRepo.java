package org.labsis.gestione_ristorante.repository.admin;

import org.labsis.gestione_ristorante.entity.admin.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
