package sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(length = 150, nullable = false)
    private String prenom;

    @Column(length = 250)
    private String adresse;

    @Column(length = 20)
    private String telephone;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    @Column(nullable = false)
    private LocalDateTime dateEnregistrement;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

}
