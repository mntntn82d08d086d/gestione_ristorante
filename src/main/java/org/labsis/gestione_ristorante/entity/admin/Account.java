package org.labsis.gestione_ristorante.entity.admin;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
public class Account implements Serializable {

    @EmbeddedId
    private AccountKey id;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    public Account() {}

    public Account(AccountKey id, String password) {
        this.id = id;
        this.password = password;
    }

    public Account(String username, String email, String password) {
        id = new AccountKey(username, email);
        this.password = password;
    }

    public AccountKey getId() {
        return id;
    }

    public void setId(AccountKey id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getEmail() {
        return id.getEmail();
    }

    @Transient
    public void setEmail(String email) {
        id.setEmail(email);
    }

    @Transient
    public String getUsername() {
        return id.getUsername();
    }

    @Transient
    public void setUsername(String username) {
        id.setUsername(username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equal(getId(), account.getId()) &&
                Objects.equal(getPassword(), account.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getPassword());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
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