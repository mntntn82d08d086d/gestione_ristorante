package org.labsis.gestione_ristorante.repository.risorse_umane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labsis.gestione_ristorante.entity.risorse_umane.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DipendenteRepositoryTest {

    @Qualifier("dipendenteRepository")
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void getAll() {
        Optional<Dipendente> ret = dipendenteRepository.findDipendenteByCodiceFiscale("ci5ao");
        if (ret.isPresent())
            System.out.println(ret.get() + " ciao .-.");
        else {
            System.out.println("Dipendente non presente");
        }
    }

}