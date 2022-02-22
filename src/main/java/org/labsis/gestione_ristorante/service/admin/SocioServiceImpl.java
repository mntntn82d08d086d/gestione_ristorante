package org.labsis.gestione_ristorante.service.admin;

import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.repository.admin.SocioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Documentazione
 */

@Service("socioService")
@Transactional
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;

    public SocioServiceImpl(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @Override
    public List<Socio> getAllSocio() {
        return socioRepository.findAll();
    }

    @Override
    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }
}
