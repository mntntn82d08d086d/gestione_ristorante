package org.labsis.gestione_ristorante.entity.admin;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static javax.persistence.FetchType.*;

/**
 * TODO: Documentazione
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    @SequenceGenerator(
            name = "seq_account",
            sequenceName = "seq_account",
            initialValue = 1,
            allocationSize = 100
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 90)
    private String username;

    @Column(name = "email", nullable = false, length = 90)
    private String email;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

/*
    @Transient
    public void addRole(OldRole role) {
        roles.add(role);
    }

    @Transient
    public void removeRole(OldRole role) {
        roles.remove(role);
    }

    @Transient
    public boolean removeRoleByName(String roleName) {
        Iterator<OldRole> it = roles.iterator();
        while(it.hasNext()) {
            if(it.next().getOldRole().equals(roleName)){
                it.remove();
                return true;
            }
        }
        return false;
    }
*/

}