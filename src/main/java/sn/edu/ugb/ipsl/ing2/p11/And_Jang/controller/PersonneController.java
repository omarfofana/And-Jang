package sn.edu.ugb.ipsl.ing2.p11.And_Jang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.service.IpslApiError;
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
    @Operation(
            summary = "liste des personnes",
            description = "Retourne la liste de toutes les personnes",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "La liste des personnes est retournée"
                    )
            }
    )
    @GetMapping
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> findById(@PathVariable("id") Integer idPersonne) {
        Optional<Personne> personnedb = personneService.findById(idPersonne);
        if (personnedb.isPresent()) {
            Personne personne = personnedb.get();
            return ResponseEntity.ok().body(personne);
        }
        return ResponseEntity.status(414).build();
        //return ResponseEntity.notFound().build();
        //if(personnedb.isEmpty()) {return null;}
    }

    @PostMapping
    public ResponseEntity createPersonne(@RequestBody Personne personne) {
        try {
            Personne p = personneService.create(personne);
            return ResponseEntity.status(201).body(p);
        } catch (IpslApiError e) {
            return e.getResponse();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Integer id) {
        personneService.deleteById(id);
    }
}



