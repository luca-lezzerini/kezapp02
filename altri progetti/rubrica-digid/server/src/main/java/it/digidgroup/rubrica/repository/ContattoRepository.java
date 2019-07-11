package it.digidgroup.rubrica.repository;

import it.digidgroup.rubrica.model.Contatto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends 
        JpaRepository<Contatto, Long>{

    List<Contatto> findByNomeLike(String s);
    
    @Query("select c from Contatto c"
            + " where"
            + " nome like :name")
    List<Contatto> trovaPerNomeParziale(@Param("name") String nome);
}
