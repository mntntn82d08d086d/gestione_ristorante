package org.labsis.gestione_ristorante.entity.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class ContattoTest {

    @Test
    public void getAll() {
        Contatto contatto = new Contatto();
        contatto.setContatto("132-123123");
        contatto.setTipologia(Contatto.EnumTipologia.EMAIL.getTipologia());
        contatto.setSuffix(Contatto.EnumSuffix.PERSONALE.toString());
        System.out.println(contatto);
    }
}