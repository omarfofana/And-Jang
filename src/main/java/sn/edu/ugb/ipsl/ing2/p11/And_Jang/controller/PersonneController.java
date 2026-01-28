package sn.edu.ugb.ipsl.ing2.p11.And_Jang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
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
    public List<Personne> findAll(@RequestParam(name = "search", required = false) String searchTxt) {
        if(searchTxt != null && !searchTxt.isEmpty()) {
            return personneService.search(searchTxt);
        }
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

    @Operation(
            summary = "Enregistre nouvelle personne",
            description = "Permet d'enregistrer une nouvelle personne,Id ne doit pas etre renseigner",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "La personne est enregsitrée avec succés",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"id\": 3,\n" +
                                                            "  \"nom\": \"FALL\",\n" +
                                                            "  \"prenom\": \"Fatou\",\n" +
                                                            "  \"adresse\": \"Guediawaye\",\n" +
                                                            "  \"telephone\": \"77777777\",\n" +
                                                            "  \"dateNaissance\": \"2009-01-26\",\n" +
                                                            "  \"dateEnregistrement\": \"2026-01-26T16:35:38.2911724\",\n" +
                                                            "  \"email\": \"fall@gmail.com\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(
                            responseCode = "451",
                            description = "Le prenom n'a pas ete renseigne"
                    ),
                    @ApiResponse(
                            responseCode = "452",
                            description = "Le nom n'a pas ete renseigne"
                    )
            }
    )
    @PostMapping
    public ResponseEntity createPersonne(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "La personne à créer",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = "{\n" +
                                                    "  \"nom\": \"FALL\",\n" +
                                                    "  \"prenom\": \"Fatou\",\n" +
                                                    "  \"adresse\": \"Guediawaye\",\n" +
                                                    "  \"telephone\": \"77777777\",\n" +
                                                    "  \"dateNaissance\": \"2009-01-26\",\n" +
                                                    "  \"email\": \"fall@gmail.com\"\n" +
                                                    "}\n"
                                    )
                            }
                    )
            )
            @RequestBody Personne personne) {
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



