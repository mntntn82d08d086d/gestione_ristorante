package org.labsis.gestione_ristorante.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    @SequenceGenerator(
            name = "seq_role",
            sequenceName = "seq_role",
            allocationSize = 100
    )
    private Long id;
    private String name;
}
