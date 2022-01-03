package org.labsis.gestione_ristorante.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.labsis.gestione_ristorante.entity.magazzino.Ordine;
import org.labsis.gestione_ristorante.entity.magazzino.Prodotto;
import org.labsis.gestione_ristorante.entity.magazzino.R_FP;
import org.labsis.gestione_ristorante.repository.common.ContattoRepository;
import org.labsis.gestione_ristorante.repository.magazzino.FornitoreRepository;
import org.labsis.gestione_ristorante.repository.magazzino.OrdineRepository;
import org.labsis.gestione_ristorante.repository.magazzino.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdineRepositoryTest {

    private Fornitore f1, f2;
    private Contatto c1, c2, c3;
    private Prodotto p1, p2, p3;
    private Ordine o1;
    //private R_PO r1, r2, r3;
    private R_FP rf1, rf2, rf3;

    @Autowired
    private ContattoRepository contattoRepository;

    @Autowired
    private FornitoreRepository fornitoreRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

/*
    @Autowired
    private R_FPRepository r_fpRepository;
*/

    @Autowired
    private OrdineRepository repository;

/*
    @Autowired
    private R_PORepository r_poRepository;
*/

    @BeforeEach
    void setUp() {
/*
        c1 = new Contatto(1L, Contatto.Tipologia.TELEFONO, Contatto.Suffix.PRINCIPALE, "123-4561234");
        c2 = new Contatto(2L, Contatto.Tipologia.TELEFONO, Contatto.Suffix.PRINCIPALE,"456-1234564");
        f1 = new Fornitore("123123123123123123123", "Nome Azienda 1", "Sede Legale 1", "Citta' 1");
        f1.addContatto(c1);
        f2 = new Fornitore("456456456456456456465", "Nome Azienda 2", "Sede Legale 2", "Citta' 2");
        f2.addContatto(c2);

        p1 = new Prodotto(1L, "Prodotto 1", "Tipologia 1", "Marca 1");
        p2 = new Prodotto(2L, "Prodotto 2", "Tipologia 2", "Marca 2");
        p3 = new Prodotto(3L, "Prodotto 3", "Tipologia 3", "Marca 3");

        rf1 = new R_FP(new R_FPKey(f1.getId(),p1.getId()), f1, p1, 12.50, 2);
        f1.addRfp(rf1);
        p1.addRfp(rf1);
        rf2 = new R_FP(new R_FPKey(f2.getId(),p2.getId()), f2, p2, 23.00, 3);
        f2.addRfp(rf2);
        p2.addRfp(rf2);
        rf3 = new R_FP(new R_FPKey(f2.getId(),p3.getId()), f2, p3, 31.00, 2);
        f2.addRfp(rf3);
        p3.addRfp(rf3);

        o1 = new Ordine("1AA" , new java.sql.Date(LocalDate.now().toEpochDay()), "");

        r1 = new R_PO(p1, o1, 5.0);
        p1.addRpo(r1);
        o1.addRpo(r1);
        r2 = new R_PO(p2, o1, 4.0);
        p2.addRpo(r2);
        o1.addRpo(r2);
        r3 = new R_PO(p3, o1, 6.0);
        p3.addRpo(r3);
        o1.addRpo(r3);

        contattoRepository.save(c1);
        contattoRepository.save(c2);
        fornitoreRepository.save(f1);
        fornitoreRepository.save(f2);

        prodottoRepository.save(p1);
        prodottoRepository.save(p2);
        prodottoRepository.save(p3);

        repository.save(o1);
        r_poRepository.save(r1);
        r_poRepository.save(r2);
        r_poRepository.save(r3);
*/
    }

    @Test
    public void getAll() {
/*
        List<Contatto> lc = contattoRepository.findAll();
        if(!lc.isEmpty()) {
            System.out.println("Lista Contatti:");
            for (Contatto c : lc) {
                System.out.println(c);
            }
        } else {
            System.out.println("Lista Contatti vuota");
        }

        List<Fornitore> lf = fornitoreRepository.findAll();
        if(!lf.isEmpty()) {
            System.out.println("Lista Fornitori:");
            for (Fornitore f : lf) {
                System.out.println(f);
                System.out.println(f.getContatti().toString());
            }
        } else {
            System.out.println("Lista Fornitori vuota");
        }

        List<Prodotto> lp = prodottoRepository.findAll();
        if(!lp.isEmpty()) {
            System.out.println("Lista Prodotti:");
            for (Prodotto p : lp) {
                System.out.println(p);
            }
        } else {
            System.out.println("Lista Prodotti vuota");
        }

        List<R_FP> lrfp = r_fpRepository.findAll();
        if(!lrfp.isEmpty()) {
            System.out.println("Lista R_FP:");
            for(R_FP r : lrfp){
                System.out.println(r);
            }
        } else {
            System.out.println("Lista R_FP vuota");
        }

        List<Ordine> lo = repository.findAll();
        if(!lo.isEmpty()) {
            System.out.println("Lista Ordini:");
            for (Ordine o : lo) {
                System.out.println(o);
            }
        } else {
            System.out.println("Lista Ordini vuota");
        }

        List<R_PO> lrpo = r_poRepository.findAll();
        if(!lrpo.isEmpty()) {
            System.out.println("Lista R_PO:");
            for (R_PO r : lrpo) {
                System.out.println(r);
            }
        } else {
            System.out.println("Lista R_PO vuota");
        }
*/
    }
}