package org.labsis.gestione_ristorante.repository.magazzino;

import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomProdottoRepositoryImpl implements CustomProdottoRepository {

    private final EntityManager entityManager;

    public CustomProdottoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Prodotto> saveProdotto(Prodotto prodotto) {
        // FIXME: testare l'eventualità che fornitore sia già presente nel database
        Optional<Prodotto> ret = Optional.empty();
        Prodotto p = entityManager.find(Prodotto.class, prodotto.getId());
        if(p == null) {
            entityManager.persist(prodotto);
            ret = Optional.of(prodotto);
        }
        return ret;
    }

    @Override
    public Optional<Prodotto> updateProdotto(Prodotto prodotto, Long id) {
        Optional<Prodotto> ret = Optional.empty();
        Prodotto existingProdotto = entityManager.find(Prodotto.class, id);
        if(existingProdotto != null) {
            entityManager.remove(existingProdotto);
            existingProdotto.setId(prodotto.getId());
            existingProdotto.setNome(prodotto.getNome());
            existingProdotto.setTipologia(prodotto.getTipologia());
            existingProdotto.setMarca(prodotto.getMarca());
            entityManager.persist(existingProdotto);
            ret = Optional.of(existingProdotto);
        }
        return ret;
    }

    @Override
    public Optional<Prodotto> deleteProdottoById(Long id) {
        Optional<Prodotto> ret = Optional.empty();
        Prodotto p = entityManager.find(Prodotto.class, id);
        if(p != null) {
            entityManager.remove(p);
            ret = Optional.of(p);
        }
        return ret;
    }
}
