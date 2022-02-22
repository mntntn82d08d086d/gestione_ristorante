package org.labsis.gestione_ristorante.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OldRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_old_role")
    @SequenceGenerator(
            name = "seq_old_role",
            sequenceName = "seq_old_role",
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

    public enum RolesName {
        ADMIN("ADMIN"), MAG("MAG"), CLIENT("CLIENT"), DIP("DIP");

        RolesName(String roleName) {
            this.roleName = roleName;
        }

        private String roleName;
    }
}