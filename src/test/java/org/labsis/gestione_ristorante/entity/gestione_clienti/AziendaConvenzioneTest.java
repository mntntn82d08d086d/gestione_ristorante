package org.labsis.gestione_ristorante.entity.gestione_clienti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.common.Contatto;
import org.labsis.gestione_ristorante.repository.gestione_cliente.ConvenzioneRepository;
import org.labsis.gestione_ristorante.service.common.ContattoService;
import org.labsis.gestione_ristorante.service.gestione_clienti.AziendaConvenzioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.labsis.gestione_ristorante.entity.common.Contatto.EnumSuffix;
import static org.labsis.gestione_ristorante.entity.common.Contatto.EnumTipologia;

@SpringBootTest
class AziendaConvenzioneTest {

    private AziendaConvenzione ac;

    @Autowired
    private AziendaConvenzioneService acs;

    @Autowired
    private ConvenzioneRepository convenzioneRepository;

    @Autowired
    private ContattoService contattoService;

    @BeforeEach
    void setUp() {
        ac = new AziendaConvenzione();
        ac.setPiva("123123123");
        ac.setNomeAzienda("Nome Azienda 1");
        ac.setSedeLegale("Sede Legale 1");
        ac.setCitta("Città 1");
        ac.setPrefixTessera(ac.generatePrefix(ac.getPiva(), ac.getNomeAzienda(), ac.getCitta()));
/*
        Convenzione convenzione = new Convenzione();
        convenzione.setCodiceConvenzione("1A34");
        convenzione.setDataStipula(new Date(System.currentTimeMillis()));
        convenzione.setSconto(6.00);
        ac.setConvenzione(convenzione);
        Contatto c1 = new Contatto();
        c1.setTipologia(EnumTipologia.TELEFONO.getTipologia());
        c1.setSuffix(EnumSuffix.PRINCIPALE.getSuffix());
        c1.setContatto("132-123456");
        Contatto c2 = new Contatto();
        c2.setTipologia(EnumTipologia.EMAIL.getTipologia());
        c2.setSuffix(EnumSuffix.PRINCIPALE.getSuffix());
        c2.setContatto("antonio@gmail.com");
        ac.addContatto(c1);
        ac.addContatto(c2);
        convenzioneRepository.save(convenzione);
        contattoService.saveContatto(c1);
        contattoService.saveContatto(c2);
*/
        acs.saveAziendaConvenzione(ac);
        ac = acs.getAziendaConvenzioneByNomeAzienda("Nome Azienda 1").get();
    }

    @Test
    void addContatto() {
        Contatto c3 = new Contatto();
        c3.setTipologia(EnumTipologia.EMAIL.getTipologia());
        c3.setSuffix(EnumSuffix.SECONDARIO.getSuffix());
        c3.setContatto("ciccio@yahoo.com");
        contattoService.saveContatto(c3);
        ac.addContatto(c3);
        acs.saveAziendaConvenzione(ac);
        if(ac == null)
            ac = acs.getAziendaConvenzioneByNomeAzienda("Nome Azienda 1").get();
        System.out.println(ac);
    }

    @Test
    void removeContattoByTipologia() {
        System.out.println(ac);
        ac.removeContattoByTipologia(EnumTipologia.EMAIL.getTipologia());
        System.out.println(ac);
    }

    @Test
    void removeContattoByTipologiaAndSuffix() {
        System.out.println(ac);
        ac.removeContattoByTipologiaAndSuffix(EnumTipologia.TELEFONO.getTipologia(), EnumSuffix.PRINCIPALE.getSuffix());
        System.out.println(ac);
    }
}