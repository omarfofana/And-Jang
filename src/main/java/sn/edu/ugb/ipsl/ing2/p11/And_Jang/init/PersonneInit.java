package sn.edu.ugb.ipsl.ing2.p11.And_Jang.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories.PersonneRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class PersonneInit implements CommandLineRunner {

    private final PersonneRepository personneRepository;
    public PersonneInit(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        if (personneRepository.count() == 0) {
            System.out.println("PersonneInit...");
            Personne p1 = new Personne();
            p1.setNom("Boly");
            p1.setPrenom("Abdoulaye");
            p1.setDateEnregistrement(LocalDateTime.now());
            p1.setDateNaissance(LocalDate.of(2006  , 6, 7));
            p1.setEmail("abdoulaye-Boly@ugb.edu.sn");
            personneRepository.save(p1);

            Personne p2 = Personne.builder()
                    .nom("FOFANA")
                    .prenom("Cheikh Oumar")
                    .dateEnregistrement(LocalDateTime.now())
                    .dateNaissance(LocalDate.of(2006  , 6, 7))
                    .email("fofana-cheikh-oumar@ugb.edu.sn")
                    .adresse("Dakar")
                    .telephone("76 192 12 63")
                    .build();
            personneRepository.save(p2);
        }
    }

}
