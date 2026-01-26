package sn.edu.ugb.ipsl.ing2.p11.And_Jang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cartes")
@Tag(
        name = "Gestion des cartes",
        description = "gere toutes les operations sur les cartes (ajout, modification, suppression)"
)

public class CarteController {
    @GetMapping
    @Operation(
            tags = "Gestion des etudiants"
    )
    public String test() {
        return "test";
    }
    @GetMapping("/test2")
    public String test2() {
        return "test 2";
    }
}
