package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Chat21;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository21 extends JpaRepository<Chat21, Long>{
    Chat21 findByNickName(String nickname);
    
    Chat21 findBySessione(String sessione);

}
