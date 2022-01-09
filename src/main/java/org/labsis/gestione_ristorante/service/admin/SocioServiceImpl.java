package org.labsis.gestione_ristorante.service.admin;

import lombok.RequiredArgsConstructor;
import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.repository.admin.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service
@Transactional
@RequiredArgsConstructor
public class SocioServiceImpl implements SocioService {

    @Autowired
    private final SocioRepository repository;

    @Override
    public List<Socio> getAllSocio() {
        return repository.findAll();
    }
}
