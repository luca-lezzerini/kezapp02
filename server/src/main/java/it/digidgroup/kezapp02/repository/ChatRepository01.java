package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Chat0;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository01 
        extends JpaRepository<Chat0, Long>{
    Chat0 findByNickname(String nickname);
}
