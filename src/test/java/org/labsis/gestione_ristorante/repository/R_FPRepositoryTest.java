package org.labsis.gestione_ristorante.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.repository.magazzino.FornitoreRepository;
import org.labsis.gestione_ristorante.repository.magazzino.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class R_FPRepositoryTest {

    private Fornitore f1, f2;
    private Prodotto p1, p2;
    private R_FP r1, r2;
    //private R_FPKey k1, k2;

/*
    @Autowired
    private R_FPRepository repository;
*/

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private FornitoreRepository fornitoreRepository;

    @BeforeEach
    void setUp() {
/*
        f1 = new Fornitore("123123123123123123123", "Nome Azienda 1", "Sede Legale 1", "Citta' 1");
        fornitoreRepository.save(f1);
        f2 = new Fornitore("456456456456456456465", "Nome Azienda 2", "Sede Legale 2", "Citta' 2");
        fornitoreRepository.save(f2);
        p1 = new Prodotto(1L, "Prodotto 1", "Tipologia 1", "Marca 1");
        prodottoRepository.save(p1);
        p2 = new Prodotto(2L,"Prodotto 2", "Tipologia 2", "Marca 2");
        prodottoRepository.save(p2);
        r1 = new R_FP(new R_FPKey(f1.getId(), p1.getId()), f1, p1, 12.50, 2);
        f1.addRfp(r1); p1.addRfp(r1);
        r2 = new R_FP(new R_FPKey(f2.getId(), p2.getId()),f2, p2, 21.00, 1);
        f2.addRfp(r2); p1.addRfp(r2);
        repository.save(r1);
        repository.save(r2);
*/
    }

    @Test
    public void getAll() {
/*
        List<R_FP> lrfp = repository.findAll();
        if(!lrfp.isEmpty()) {
            System.out.println("Lista R_FP:");
            for(R_FP r : lrfp){
                System.out.println(r);
            }
        } else {
            System.out.println("Lista R_FP vuota");
        }
*/
    }
}