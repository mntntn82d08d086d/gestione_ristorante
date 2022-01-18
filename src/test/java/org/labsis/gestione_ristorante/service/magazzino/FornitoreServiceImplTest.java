package org.labsis.gestione_ristorante.service.magazzino;

import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.magazzino.Fornitore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.Optional;

@SpringBootTest
class FornitoreServiceImplTest {

    @Autowired
    private FornitoreService fornitoreService;

    @Test
    void updateFornitore() {
        Optional<Fornitore> opt1 = fornitoreService.getFornitoreByPiva("123123123");
        System.out.println("insert new partita iva: 132123123");
        if(opt1.isPresent()) {
            Fornitore existingF = opt1.get();
            existingF.setPiva("132123123");
            existingF.setNomeAzienda("Nome Azienda 1");
            existingF.setSedeLegale("Sede Legale 1");
            existingF.setCitta("Città 1");
            existingF.setContatti(new LinkedHashSet<>());
            fornitoreService.updateFornitore(existingF, "123123123");
        }
        Optional<Fornitore> opt2 = fornitoreService.getFornitoreByPiva("132123123");
        if(opt2.isPresent()) {
            Fornitore newF = opt2.get();
            System.out.println(newF);
        }
    }

    @Test
    void saveFornitore() {
        Fornitore fnew = new Fornitore();
        fnew.setPiva("456456456");
        fnew.setNomeAzienda("Nome Azienda 4");
        fnew.setSedeLegale("Sede Legale 4");
        fnew.setCitta("Città 4");
        fnew.setContatti(new LinkedHashSet<>());
        Optional<Fornitore> opt1 = fornitoreService.saveFornitore(fnew);
        if(opt1.isPresent()) {
            Fornitore f = opt1.get();
            System.out.println("Primo saveFornitore.\nFornitore viene inserito:\n" + f);
        }
        Optional<Fornitore> opt2 = fornitoreService.saveFornitore(fnew);
        if(opt2.isEmpty()){
            System.out.println("Secondo saveFornitore.\nFornitore non viene inserito\n");
        }
    }

    @Test
    void deleteFornitore() {
        Fornitore fnew = new Fornitore();
        fnew.setPiva("789789789");
        fnew.setNomeAzienda("Nome Azienda 3");
        fnew.setSedeLegale("Sede Legale 3");
        fnew.setCitta("Città 3");
        fnew.setContatti(new LinkedHashSet<>());
        Optional<Fornitore> opt1 = fornitoreService.saveFornitore(fnew);
        if(opt1.isPresent()) {
            Fornitore f = opt1.get();
            System.out.println("Fornitore viene inserito:\n" + f);
        }
        Optional<Fornitore> opt2 = fornitoreService.deleteFornitoreByPiva("789789789");
        if(opt2.isPresent()) {
            Fornitore frem = opt2.get();
            System.out.println("Rimozione dal database di Fornitore:\n" + frem);
        }
        Optional<Fornitore> opt3 = fornitoreService.deleteFornitoreByPiva("789789789");
        if(opt3.isEmpty()) {
            System.out.println("Fornitore già rimosso dal database\n");
        }

    }
}