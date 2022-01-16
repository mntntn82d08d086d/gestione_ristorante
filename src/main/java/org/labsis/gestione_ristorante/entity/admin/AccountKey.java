package org.labsis.gestione_ristorante.entity.admin;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountKey implements Serializable {

    @Column(name = "username", nullable = false, length = 90)
    private String username;

    @Column(name = "email", nullable = false, length = 90)
    private String email;

    public AccountKey() {
    }

    public AccountKey(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountKey)) return false;
        AccountKey that = (AccountKey) o;
        return Objects.equal(getUsername(), that.getUsername()) && Objects.equal(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUsername(), getEmail());
    }

    @Override
    public String toString() {
        return "AccountKey{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
