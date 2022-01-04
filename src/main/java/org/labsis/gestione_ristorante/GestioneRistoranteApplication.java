package org.labsis.gestione_ristorante;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO: Documentazione
 */

@SpringBootApplication
@EnableAdminServer
public class GestioneRistoranteApplication /*implements CommandLineRunner */{

    private static final Logger log = LoggerFactory.getLogger(GestioneRistoranteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GestioneRistoranteApplication.class, args);
    }

/*
    @Autowired
    private FornitoreRepository repository;

    @Autowired
    private ContattoRepository contattoRepository;

    @Override
    public void run(String... args) throws Exception {

    }
*/
}
