package sn.edu.ugb.ipsl.ing2.p11.And_Jang.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories.PersonneRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }
    public Optional<Personne> findById(Integer id) {
        return personneRepository.findById(id);
    }

    public Personne create(Personne personne) throws IpslApiError {
        if (personne.getPrenom() == null || personne.getPrenom().isBlank()) {
            throw new IpslApiError(451,"le nom est obligatoire");
        }
        if (personne.getEmail() == null || personne.getEmail().isBlank()) {
            throw new IpslApiError(450,"email est obligatoire");
        }
        if (personne.getNom() == null || personne.getNom().isBlank()) {
            throw new IpslApiError(452,"le nom est obligatoire");
        }
        String email = personne.getEmail().trim();
        Optional<Personne> personneOptional = personneRepository.findByEmail(personne.getEmail());
        if (personneOptional.isPresent()) {
            throw new IpslApiError(409,"L'adresse email '"+personne.getEmail()+"' existe deja");
        }
        return personneRepository.save(personne);
    }

    public void delete(Personne personne) {
        personneRepository.delete(personne);
    }
    public void deleteById(Integer id) {
        personneRepository.deleteById(id);
    }
    public Personne update(Personne personne) {
        return personneRepository.save(personne);
    }

    private Optional<Personne> findByEmail(String email) {
        return personneRepository.findByEmail(email);
    }
    public List<Personne> search(String txt){
        return personneRepository.search(txt);
    }

    @Transactional
    public void chargerDonneesTest(){
        if (personneRepository.count() == 0) {
            System.out.println("PersonneInit...");
            Personne p1 = new Personne();
            p1.setNom("Boly");
            p1.setTelephone("1234567890");
            p1.setPrenom("Abdoulaye");
            p1.setDateEnregistrement(LocalDateTime.now());
            p1.setDateNaissance(LocalDate.of(2006  , 6, 7));
            p1.setEmail("boly@ugb.edu.sn");
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
