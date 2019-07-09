package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Chat3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository3 extends JpaRepository<Chat3, Long>{
     
    Chat3 findByNickName(String nickName);
}
