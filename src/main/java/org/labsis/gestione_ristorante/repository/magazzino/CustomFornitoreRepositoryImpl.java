package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.GestioneRistoranteApplication;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class CustomFornitoreRepositoryImpl implements CustomFornitoreRepository {

    private static final Logger log = LoggerFactory.getLogger(CustomFornitoreRepositoryImpl.class);
    private final EntityManager entityManager;

    public CustomFornitoreRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Fornitore> saveFornitore(Fornitore fornitore) {
        Optional<Fornitore> ret = Optional.empty();
        Fornitore f1 = entityManager.find(Fornitore.class, fornitore.getPiva());
        if(f1 == null) {
            try{
                entityManager.persist(fornitore);
                entityManager.flush();
                ret = Optional.of(fornitore);
            } catch (Exception e) {
                log.info("message: " + e.getMessage() +"\n" + e.toString());
            }
        }
        return ret;
    }

    @Override
    public Optional<Fornitore> updateFornitore(Fornitore fornitore, String piva) {
        Optional<Fornitore> ret = Optional.empty();
        Fornitore existingFornitore = entityManager.find(Fornitore.class, piva);
        if(existingFornitore != null) {
            entityManager.remove(existingFornitore);
            existingFornitore.setPiva(fornitore.getPiva());
            existingFornitore.setNomeAzienda(fornitore.getNomeAzienda());
            existingFornitore.setSedeLegale(fornitore.getSedeLegale());
            existingFornitore.setCitta(fornitore.getCitta());
            existingFornitore.setContatti(fornitore.getContatti());
            entityManager.persist(existingFornitore);
            ret = Optional.of(existingFornitore);
        }
        return ret;
    }

    @Override
    public Optional<Fornitore> deleteFornitoreByPiva(String piva) {
        Optional<Fornitore> ret = Optional.empty();
        Fornitore f = entityManager.find(Fornitore.class, piva);
        if(f != null) {
            entityManager.remove(f);
            ret = Optional.of(f);
        }
        return ret;
    }
}
