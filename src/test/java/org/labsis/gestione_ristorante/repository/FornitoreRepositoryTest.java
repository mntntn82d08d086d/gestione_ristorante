package org.labsis.gestione_ristorante.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.repository.common.ContattoRepository;
import org.labsis.gestione_ristorante.repository.magazzino.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FornitoreRepositoryTest {

    private Contatto c1, c2, c3;
    private Fornitore f1, f2;

    @Autowired
    private ContattoRepository contattoRepository;

    @Autowired
    private FornitoreRepository repository;

    @BeforeEach
    void setUp() {
/*
        c1 = new Contatto(1L, Contatto.Tipologia.TELEFONO, Contatto.Suffix.PRINCIPALE, "123-4561234");
        c2 = new Contatto(2L, Contatto.Tipologia.TELEFONO, Contatto.Suffix.PRINCIPALE,"456-1234564");
        c3 = new Contatto(3L, Contatto.Tipologia.TELEFONO, Contatto.Suffix.PERSONALE, "789-4561234");

        f1 = new Fornitore("123123123123123123123", "Nome Azienda 1", "Sede Legale 1", "Citta' 1");
        f1.addContatto(c1);

        f2 = new Fornitore("456456456456456456465", "Nome Azienda 2", "Sede Legale 2", "Citta' 2");
        f2.addContatto(c2);

        contattoRepository.save(c1);
        contattoRepository.save(c2);
        contattoRepository.save(c3);
        repository.save(f1);
        repository.save(f2);
*/
    }

    @Test
    public void getAll() {
/*
        List<Fornitore> lf = repository.findAll();
        if(!lf.isEmpty()) {
            System.out.println("Lista Fornitori:");
            for (Fornitore f : lf) {
                System.out.println(f);
                System.out.println(f.getContatti().toString());
            }
        } else {
            System.out.println("Lista Fornitori vuota");
        }

        List<Contatto> lc = contattoRepository.findAll();
        if(!lc.isEmpty()) {
            System.out.println("Lista Contatti:");
            for (Contatto c : lc) {
                System.out.println(c);
            }
        } else {
            System.out.println("Lista Contatti vuota");
        }
*/
    }
}