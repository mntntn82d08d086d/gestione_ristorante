package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomConvenzioneRepository {

    Optional<Convenzione> saveConvenzione(Convenzione convenzione);

    Optional<Convenzione> updateConvenzione(Convenzione convenzione, Long id);

    Optional<Convenzione> deleteConvenzioneById(Long id);

}
