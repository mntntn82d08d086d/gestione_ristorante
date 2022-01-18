package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.entity.magazzino.R_FPKey;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Component
public interface R_FPService {

    List<R_FP> getAllForniture();

    Optional<R_FP> getFornituraByProdottoId(Long id);

    List<R_FP> getFornituraByFornitorePiva(String piva);

    Integer countFornitureByFornitorePiva(String piva);

    Optional<R_FP> saveFornitura(R_FP fornitura);

    Optional<R_FP> updateFornitura(R_FP fornitura, R_FPKey id);

    Optional<R_FP> deleteFornitura(R_FPKey id);

}
