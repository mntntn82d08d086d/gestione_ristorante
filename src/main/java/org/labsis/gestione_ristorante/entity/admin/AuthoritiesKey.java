package org.labsis.gestione_ristorante.entity.admin;

import java.io.Serializable;

/*
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
*/
public class AuthoritiesKey implements Serializable {

    //@Column(name = "account_id")
    private Long accountId;

    //@Column(name = "role_id")
    private Long roleId;

}
