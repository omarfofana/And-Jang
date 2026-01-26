package sn.edu.ugb.ipsl.ing2.p11.And_Jang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories.PersonneRepository;

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
        if (personne.getNom() == null || personne.getNom().isBlank()) {
            throw new IpslApiError(452,"le nom est obligatoire");
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


}
