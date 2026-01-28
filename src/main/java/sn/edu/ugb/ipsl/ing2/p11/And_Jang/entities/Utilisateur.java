package sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;



    @Column(name = "nom", nullable = false, length = 100)
    private String nom;



    @Column(name = "email", nullable = false, length = 150)
    private String email;


    @Column(name = "date_creation")
    private Instant dateCreation;


    @Column(name = "actif")
    private Boolean actif;

}