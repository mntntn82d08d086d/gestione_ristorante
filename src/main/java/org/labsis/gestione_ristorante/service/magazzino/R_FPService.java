package org.labsis.gestione_ristorante.service.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.R_FP;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

public interface R_FPService {

    List<R_FP> getAllForniture();

    Optional<R_FP> getFornituraByProdottoId(Long id);

    Integer countFornitureByFornitoreId(Long id);

    R_FP saveFornitura(R_FP fornitura);

    R_FP updateFornitura(R_FP fornitura);

    void deleteFornitura(Long id);

    List<R_FP> getFornituraByFornitoreId(Long id);
}
