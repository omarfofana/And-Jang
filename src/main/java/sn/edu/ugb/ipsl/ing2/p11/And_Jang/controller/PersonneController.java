package sn.edu.ugb.ipsl.ing2.p11.And_Jang.controller;

import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.service.PersonneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/personnes")
public class PersonneController {
    private final PersonneService personneService;
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    //   http://localhost:8080/api/v1/personnes
    @GetMapping
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @GetMapping("/test/{id}")
    public Personne findById(@PathVariable("id") Integer idPersonne) {
        Optional<Personne> personnedb = personneService.findById(idPersonne);
        if (personnedb.isPresent()) {
            return personnedb.get();
        }
        return null;
        //if(personnedb.isEmpty()) {return null;}
    }

    @PostMapping
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneService.save(personne);
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Integer id) {
        personneService.deleteById(id);
    }
}



