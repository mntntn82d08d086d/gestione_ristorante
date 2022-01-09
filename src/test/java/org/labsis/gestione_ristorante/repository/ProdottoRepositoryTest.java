package org.labsis.gestione_ristorante.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.repository.magazzino.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProdottoRepositoryTest {

    private Prodotto p1, p2;

    @Autowired
    private ProdottoRepository repository;

    @BeforeEach
    void setUp() {
/*
        p1 = new Prodotto(1L,"Prodotto 1", "Tipologia 1", "Marca 1");
        p2 = new Prodotto(2L,"Prodotto 2", "Tipologia 2", "Marca 2");
        repository.save(p1);
        repository.save(p2);
*/
    }

    @Test
    public void getAll() {
/*
        List<Prodotto> lp = repository.findAll();
        if(!lp.isEmpty()) {
            System.out.println("Lista Prodotti:");
            for(Prodotto p : lp){
                System.out.println(p);
            }
        } else {
            System.out.println("Lista Prodotti vuota");
        }
*/
    }
}