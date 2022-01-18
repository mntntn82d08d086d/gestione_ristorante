package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomOrdineRepositoryImpl implements CustomOrdineRepository {

    private final EntityManager entityManager;

    public CustomOrdineRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Ordine> saveOrdine(Ordine ordine) {
        // FIXME: testare l'eventualità che fornitore sia già presente nel database
        Optional<Ordine> ret = Optional.empty();
        Ordine o = entityManager.find(Ordine.class, ordine.getId());
        if(o == null) {
            entityManager.persist(ordine);
            ret = Optional.of(ordine);
        }
        return ret;
    }

    @Override
    public Optional<Ordine> updateOrdine(Ordine ordine, Long id) {
        Optional<Ordine> ret = Optional.empty();
        Ordine existingOrdine = entityManager.find(Ordine.class, id);
        if(existingOrdine != null) {
            entityManager.remove(existingOrdine);
            entityManager.flush();
            existingOrdine.setId(ordine.getId());
            existingOrdine.setCodiceOrdine(ordine.getCodiceOrdine());
            existingOrdine.setDataRichiesta(ordine.getDataRichiesta());
            existingOrdine.setOrdineEvaso(ordine.getOrdineEvaso());
            existingOrdine.setNota(ordine.getNota());
            entityManager.persist(existingOrdine);
            ret = Optional.of(existingOrdine);
        }
        return ret;
    }

    @Override
    public Optional<Ordine> deleteOrdineById(Long id) {
        Optional<Ordine> ret = Optional.empty();
        Ordine o = entityManager.find(Ordine.class, id);
        if(o != null) {
            entityManager.remove(o);
            ret = Optional.of(o);
        }
        return ret;
    }
}
