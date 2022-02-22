package org.labsis.gestione_ristorante.repository.common;

import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO: Documentazione
 */

@Repository("contattoRepository")
public interface ContattoRepository extends JpaRepository<Contatto, Long>, CustomContattoRepository {

    Optional<Contatto> findContattoById(Long id);

    Optional<Contatto> findContattoByContatto(String contatto);

}