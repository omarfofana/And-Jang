package sn.edu.ugb.ipsl.ing2.p11.And_Jang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.edu.ugb.ipsl.ing2.p11.And_Jang.entities.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    Optional<Personne> findByEmail(String email);

    @Query("select p from Personne p where p.prenom like %:txt% or p.nom like %:txt%")
    List<Personne> search(@Param("txt") String txt);


}
