package org.labsis.gestione_ristorante.entity.admin;

import java.io.Serializable;

/*
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
*/
public class Authorities implements Serializable {

    //@EmbeddedId
    private AuthoritiesKey id;

/*
    @MapsId("accountId")
    @ManyToOne
    @JoinColumn(name = "account_id")
*/
    private Account account;

/*
    @MapsId("roleId")
    @ManyToOne
    @JoinColumn(name = "role_id")
*/
    private OldRole oldRole;

}
