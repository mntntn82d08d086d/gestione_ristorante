package org.labsis.gestione_ristorante.service.common;

import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.labsis.gestione_ristorante.entity.common.Contatto.EnumSuffix.*;
import static org.labsis.gestione_ristorante.entity.common.Contatto.EnumTipologia.*;

@SpringBootTest
class ContattoServiceImplTest {

    @Autowired
    private ContattoService service;

    @Test
    void getAllContatti() {
        Contatto c1 = new Contatto();
        c1.setTipologia(TELEFONO.getTipologia());
        c1.setSuffix(LAVORO.getSuffix());
        c1.setContatto("123-456123");
        service.saveContatto(c1);
        Contatto c2 = new Contatto();
        c2.setTipologia(EMAIL.getTipologia());
        c2.setSuffix(PRINCIPALE.getSuffix());
        c2.setContatto("antonio@gmail.com");
        service.saveContatto(c2);
        iterateContatti();
    }

    @Test
    void getContattoById() {
        Contatto c1 = new Contatto();
        c1.setTipologia(TELEFONO.getTipologia());
        c1.setSuffix(PRINCIPALE.getSuffix());
        c1.setContatto("456-123123");
        Contatto c_ins = service.saveContatto(c1);
        c1 = service.getContattoById(c_ins.getId());
        System.out.println(c1);
        iterateContatti();
        service.deleteContattoById(c_ins.getId());
    }

    @Test
    void saveContatto() {
        Contatto c1 = new Contatto();
        c1.setTipologia(TELEFONO.getTipologia());
        c1.setSuffix(LAVORO.getSuffix());
        c1.setContatto("123-456123");
        service.saveContatto(c1);
        iterateContatti();
    }

    @Test
    void deleteContattoById() {
        Contatto c1 = new Contatto();
        c1.setTipologia(TELEFONO.getTipologia());
        c1.setSuffix(LAVORO.getSuffix());
        c1.setContatto("123-456123");
        Contatto c_ins = service.saveContatto(c1);
        iterateContatti();
        service.deleteContattoById(c_ins.getId());
    }

    private void iterateContatti() {
        List<Contatto> lc = service.getAllContatti();
        for(Contatto c : lc) {
            System.out.println(c);
        }
    }
}