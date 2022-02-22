package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Component
public class CustomOrdineRepositoryImpl implements CustomOrdineRepository {

    private final EntityManager entityManager;

    public CustomOrdineRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Metodo per salvare l'entità Ordine nel database
     *
     * @param ordine
     * @return
     */
    @Override
    public Optional<Ordine> saveOrdine(Ordine ordine) {
        // FIXME: testare l'eventualità che ordine sia già presente nel database
        Optional<Ordine> ret = Optional.empty();
        try {
            TypedQuery<Ordine> query = entityManager.createQuery("SELECT o FROM Ordine o WHERE o.codiceOrdine = ?1", Ordine.class);
            Ordine existingOrdine = query.setParameter(1, ordine.getCodiceOrdine()).getSingleResult();
            if(existingOrdine != null)
                return ret;
        } catch (NoResultException e) {
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
            existingOrdine.setId(ordine.getId());
            existingOrdine.setCodiceOrdine(ordine.getCodiceOrdine());
            existingOrdine.setDataRichiesta(ordine.getDataRichiesta());
            existingOrdine.setOrdineEvaso(ordine.getOrdineEvaso());
            existingOrdine.setNota(ordine.getNota().trim());
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
