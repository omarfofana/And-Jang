package sn.edu.ugb.ipsl.ing2.p11.And_Jang.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories.PersonneRepository;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.service.PersonneService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Order(2)
public class PersonneInit implements CommandLineRunner {

    private final PersonneRepository personneRepository;
    private final PersonneService personneService;

    public PersonneInit(PersonneRepository personneRepository, PersonneService personneService) {
        this.personneRepository = personneRepository;
        this.personneService = personneService;
    }



    @Override
    public void run(String... args) throws Exception {
        personneService.chargerDonneesTest();
    }

}
