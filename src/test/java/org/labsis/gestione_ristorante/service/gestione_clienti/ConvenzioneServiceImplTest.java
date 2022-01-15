package org.labsis.gestione_ristorante.service.gestione_clienti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.gestione_clienti.Convenzione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ConvenzioneServiceImplTest {

    @Autowired
    private ConvenzioneService service;

    @BeforeEach
    void setUp() {
/*
        Convenzione convenzione = new Convenzione();
        convenzione.setCodiceConvenzione("1AS");
        convenzione.setSconto(6.00);
        convenzione.setDataStipula(new Date(System.currentTimeMillis()));
        service.saveConvenzione(convenzione);
*/
    }

    @Test
    void getConvenzioneByCodice() {
        Convenzione convenzione = service.getConvenzioneByCodiceConvenzione("1AS");
        System.out.println(convenzione);
    }

    @Test
    void getConvenzioneByDataStipula() {
        Date dataStipula = new Date(System.currentTimeMillis());
        List<Convenzione> lc = service.getConvenzioneByDataStipula(dataStipula);
        for(Convenzione convenzione : lc) {
            System.out.println(convenzione);
        }
    }
}