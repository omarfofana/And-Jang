package sn.edu.ugb.ipsl.ing2.p11.And_Jang.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories.PersonneRepository;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.service.PersonneService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Order(2)
@Profile({"dev"})

public class PersonneInit implements CommandLineRunner {
    String[] prenomsFilles = {
            // Prénoms sénégalais (40)
            "Aïssatou", "Fatou", "Aminata", "Khady", "Sokhna",
            "Mariama", "Adja", "Astou", "Coumba", "Mame",
            "Ndeye", "Ramatoulaye", "Rokhaya", "Yacine", "Binta",
            "Awa", "Dieynaba", "Fanta", "Hawa", "Kiné",
            "Maimouna", "Nafi", "Oumy", "Penda", "Salimata",
            "Saly", "Nabou", "Ndèye Khady", "Sokhna Binta", "Arame",
            "Mbayang", "Codou", "Dior", "Néné", "Yama",
            "Seynabou", "Adjara", "Ndeye Astou", "Fari", "Tening",

            // Prénoms étrangers (10)
            "Emma", "Sofia", "Olivia", "Mia", "Lina",
            "Chloe", "Sarah", "Anna", "Maya", "Zoe"
    };
    String[] prenomsGarcons = {
            // Prénoms sénégalais (40)
            "Mamadou", "Cheikh", "Ibrahima", "Ousmane", "Serigne",
            "Moustapha", "Abdoulaye", "Babacar", "Pape", "Aliou",
            "Modou", "Lamine", "Samba", "Issa", "Malick",
            "Amadou", "El Hadji", "Moussa", "Daouda", "Bara",
            "Boubacar", "Mor", "Sidiyah", "Thierno", "Youssou",
            "Fallou", "Ibra", "Karim", "Seydou", "Alpha",
            "Demba", "Saliou", "Ansou", "Matar", "Papa",
            "Ababacar", "Massamba", "Mansour", "Khadim", "Touba",

            // Prénoms étrangers (10)
            "Lucas", "Noah", "Ethan", "Daniel", "Leo",
            "Alex", "Samuel", "Nathan", "Julien", "David"
    };
    String[] nomsDeFamille = {
            "Ndiaye", "Diop", "Fall", "Faye", "Ba",
            "Diallo", "Sow", "Sy", "Sarr", "Thiam",

            "Kane", "Seck", "Gaye", "Mbaye", "Niang",
            "Wade", "Cisse", "Gueye", "Ndao", "Dieng",

            "Ndoye", "Camara", "Toure", "Ly", "Lo",
            "Tall", "Barry", "Keita", "Kone", "Sakho",

            "Diagne", "Diakhate", "Badji", "Ndour", "Samb",
            "Coly", "Dione", "Thioye", "Sané", "Ka",

            "Pouye", "Bousso", "Diatta", "Manga", "Hanne",
            "Mendy", "Tendeng", "Basse", "Sonko", "Wone",

            "Ngom", "Diarra", "Traore", "Coulibaly", "Doucouré",
            "Sidibe", "Konaté", "Bagayoko", "Maiga", "Fofana",

            "Soumare", "Khouma", "Sagna", "Dabo", "Dramé",
            "Niane", "Dieme", "Tounkara", "Kanté", "Kouyaté",

            "Nguessan", "Beye", "Loum", "Sene", "Youm",
            "Ndaw", "Diouf", "Fadiga", "Coundoul", "Mbacke",

            "Thioune", "Ndong", "Baidy", "Guindo", "Diaw",
            "Diakhaby", "Ndoye-Bane", "Bathily", "Gningue", "Bodian",

            "Mané", "Dia", "Diatta-Ba", "Seye", "Mboup",
            "Kebe", "Tine", "Diakite", "Bamba", "Diedhiou"
    };

    private final PersonneRepository personneRepository;
    private final PersonneService personneService;

    public PersonneInit(PersonneRepository personneRepository, PersonneService personneService) {
        this.personneRepository = personneRepository;
        this.personneService = personneService;
    }



    @Override
    public void run(String... args) throws Exception {
//        personneService.chargerDonneesTest();
        int nbPersonnes = (int) (100 + 50*Math.random());
        for (int i = 0; i < nbPersonnes; i++) {
            String prenom;
            if (Math.random() < 0.12) {
                int position = (int) (Math.random() * prenomsFilles.length);
                prenom = prenomsFilles[position];
            }
            else {
                int position = (int) (Math.random() * prenomsGarcons.length);
                prenom = prenomsGarcons[position];
            }
            int posNom = (int) (Math.random() * nomsDeFamille.length);
            String nom = nomsDeFamille[posNom];
            String email = prenom +nom +i+ "@gmail.com";
            int anneeNaissance = (int) (2005+Math.random()*10);
            LocalDate dateNaissance = LocalDate.of(anneeNaissance,(int)(1+Math.random()*11),(int)(1+Math.random()*27));
            Personne personne = Personne.builder()
                    .nom(nom)
                    .email(email)
                    .dateNaissance(dateNaissance)
                    .prenom(prenom)
                    .build();
            personneRepository.save(personne);

        }

    }

}
