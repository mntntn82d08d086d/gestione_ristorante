package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomDipendenteRepositoryImpl implements CustomDipendenteRepository {

    private final EntityManager entityManager;

    public CustomDipendenteRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Dipendente> saveDipendente(Dipendente dipendente) {
        Optional<Dipendente> ret = Optional.empty();
        Dipendente d = entityManager.find(Dipendente.class, dipendente.getCodiceFiscale());
        if(d == null) {
            entityManager.persist(dipendente);
            ret = Optional.of(dipendente);
        }
        return ret;
    }

    @Override
    public Optional<Dipendente> updateDipendente(Dipendente dipendente, String codiceFiscale) {
        Optional<Dipendente> ret = Optional.empty();
        Dipendente existingDipendente = entityManager.find(Dipendente.class, codiceFiscale);
        if(existingDipendente != null) {
            entityManager.remove(existingDipendente);
            entityManager.flush();
            existingDipendente.setCodiceFiscale(dipendente.getCodiceFiscale());
            existingDipendente.setNome(dipendente.getNome());
            existingDipendente.setCognome(dipendente.getCognome());
            existingDipendente.setDataDiNascita(dipendente.getDataDiNascita());
            existingDipendente.setIndirizzo(dipendente.getIndirizzo());
            existingDipendente.setCitta(dipendente.getCitta());
            existingDipendente.setMansione(dipendente.getMansione());
            existingDipendente.setFerieDaContratto(dipendente.getFerieDaContratto());
            existingDipendente.setPermessiDaContratto(dipendente.getPermessiDaContratto());
            existingDipendente.setAccount(dipendente.getAccount());
            entityManager.persist(existingDipendente);
            ret = Optional.of(existingDipendente);
        }
        return ret;
    }

    @Override
    public Optional<Dipendente> deleteDipendenteByCodiceFiscale(String codiceFiscale) {
        Optional<Dipendente> ret = Optional.empty();
        Dipendente d = entityManager.find(Dipendente.class, codiceFiscale);
        if(d != null) {
            entityManager.remove(d);
            ret = Optional.of(d);
        }
        return ret;
    }
}
