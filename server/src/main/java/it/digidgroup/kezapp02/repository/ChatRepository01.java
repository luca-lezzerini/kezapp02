package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Chat01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository01 
        extends JpaRepository<Chat01, Long>{
    Chat01 findByNickName (String NickName);
     Chat01 findBySessione(String sessione);
}
