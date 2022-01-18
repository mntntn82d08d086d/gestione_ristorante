package org.labsis.gestione_ristorante;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.labsis.gestione_ristorante.entity.admin.Account;
import org.labsis.gestione_ristorante.entity.admin.Socio;
import org.labsis.gestione_ristorante.service.admin.AccountService;
import org.labsis.gestione_ristorante.service.admin.SocioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

/**
 * TODO: Documentazione
 */

@SpringBootApplication
//@EnableAdminServer
public class GestioneRistoranteApplication {

    private static final Logger log = LoggerFactory.getLogger(GestioneRistoranteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GestioneRistoranteApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
          userService.saveRole(new Role(null, "ROLE_USER"));
          userService.saveRole(new Role(null, "ROLE_MANAGER"));
          userService.saveRole(new Role(null, "ROLE_ADMIN"));
          userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Silvester Stallone", "silver", "1234", new ArrayList<>()));

          userService.addRoleToUser("john", "ROLE_USER");
          userService.addRoleToUser("john", "ROLE_MANAGER");
          userService.addRoleToUser("will", "ROLE_MANAGER");
          userService.addRoleToUser("jim", "ROLE_ADMIN");
          userService.addRoleToUser("silver", "ROLE_SUPER_ADMIN");
          userService.addRoleToUser("silver", "ROLE_ADMIN");
          userService.addRoleToUser("silver", "ROLE_USER");

        };
    }
*/

    @Bean
    CommandLineRunner run(SocioService socioService, AccountService accountService) {
        return args -> {
            Account ac = new Account("am8", "antoniomon@gmail.com",
                    getPasswordEncoder().encode("admin"));
            Socio admin = new Socio();
            admin.setCodiceFiscale("mntntn82");
            admin.setNome("Antonio");
            admin.setCognome("Montera");
            admin.setDataDiNascita(new Date(1982, 4, 8));
            admin.setIndirizzo("Via Martiri 22");
            admin.setCitta("Como");
            admin.setAccount(ac);
            accountService.saveAccount(ac);
            socioService.saveSocio(admin);
        };
    }
}
