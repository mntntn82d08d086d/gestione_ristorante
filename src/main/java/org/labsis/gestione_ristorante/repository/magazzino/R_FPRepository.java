package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.entity.magazzino.R_FPKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("rfpRepository")
public interface R_FPRepository extends JpaRepository<R_FP, R_FPKey>, CustomR_FPRepository {

    @Query("select r from R_FP r where r.id.prodottoId = ?1")
    Optional<R_FP> findR_FPByProdottoId(Long id);

    @Query("select r from R_FP r where r.id.fornitorePiva = ?1")
    List<R_FP> findR_FPByFornitorePiva(String piva);

    @Query("select count(r.id.fornitorePiva) as forniture from R_FP r where r.id.fornitorePiva = ?1")
    Integer countFornitureByFornitorePiva(String Piva);

}