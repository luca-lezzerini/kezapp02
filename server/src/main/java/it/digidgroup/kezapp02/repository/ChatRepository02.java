package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Chat02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository02 extends JpaRepository<Chat02, Long>{
    Chat02 findByNikname(String nikname);
}
