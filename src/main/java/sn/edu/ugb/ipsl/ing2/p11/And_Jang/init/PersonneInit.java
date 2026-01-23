package sn.edu.ugb.ipsl.ing2.p11.And_Jang.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories.PersonneRepository;

@Component
public class PersonneInit implements CommandLineRunner {

    private final PersonneRepository personneRepository;
    public PersonneInit(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("PersonneInit...");
        Personne p1 = new Personne();
        p1.setId(1);
        p1.setNom("Boly");
        p1.setPrenom("Abdoulaye");
        personneRepository.save(p1);
    }
}
