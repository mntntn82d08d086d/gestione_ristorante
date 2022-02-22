package org.labsis.gestione_ristorante.repository.gestione_cliente;

import org.labsis.gestione_ristorante.entity.gestione_clienti.AziendaConvenzione;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class CustomAziendaConvenzioneRepositoryImpl implements CustomAziendaConvenzioneRepository {

    private final EntityManager entityManager;

    public CustomAziendaConvenzioneRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<AziendaConvenzione> saveAziendaConvenzione(AziendaConvenzione aziendaConvenzione) {
        Optional<AziendaConvenzione> ret = Optional.empty();
        AziendaConvenzione ac = entityManager.find(AziendaConvenzione.class, aziendaConvenzione.getPiva());
        if(ac == null) {
            entityManager.persist(aziendaConvenzione);
            ret = Optional.of(aziendaConvenzione);
        }
        return ret;
    }

    @Override
    public Optional<AziendaConvenzione> updateAziendaConvenzione(AziendaConvenzione aziendaConvenzione, String piva) {
        Optional<AziendaConvenzione> ret = Optional.empty();
        AziendaConvenzione existingAziendaConvenzione = entityManager.find(AziendaConvenzione.class, piva);
        if(existingAziendaConvenzione != null) {
            entityManager.remove(existingAziendaConvenzione);
            entityManager.flush();
            existingAziendaConvenzione.setPiva(aziendaConvenzione.getPiva());
            existingAziendaConvenzione.setNomeAzienda(aziendaConvenzione.getNomeAzienda());
            existingAziendaConvenzione.setSedeLegale(aziendaConvenzione.getSedeLegale());
            existingAziendaConvenzione.setCitta(aziendaConvenzione.getCitta());
            existingAziendaConvenzione.setPrefixTessera(aziendaConvenzione.getPrefixTessera());
            existingAziendaConvenzione.setConvenzione(aziendaConvenzione.getConvenzione());
            existingAziendaConvenzione.setContatti(aziendaConvenzione.getContatti());
            entityManager.persist(existingAziendaConvenzione);
            ret = Optional.of(existingAziendaConvenzione);
        }
        return ret;
    }

    @Override
    public Optional<AziendaConvenzione> deleteAziendaConvenzione(String piva) {
        Optional<AziendaConvenzione> ret = Optional.empty();
        AziendaConvenzione ac = entityManager.find(AziendaConvenzione.class, piva);
        if(ac != null) {
            entityManager.remove(ac);
            ret = Optional.of(ac);
        }
        return ret;
    }
}
