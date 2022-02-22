package org.labsis.gestione_ristorante.repository.admin;

import org.labsis.gestione_ristorante.entity.admin.OldRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<OldRole, Long> {


}