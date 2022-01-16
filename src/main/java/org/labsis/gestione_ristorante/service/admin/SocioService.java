package org.labsis.gestione_ristorante.service.admin;

import org.labsis.gestione_ristorante.entity.admin.Socio;

import java.util.List;

/**
 * TODO: Documentazione
 */

public interface SocioService {

    List<Socio> getAllSocio();

    Socio saveSocio(Socio socio);

}
