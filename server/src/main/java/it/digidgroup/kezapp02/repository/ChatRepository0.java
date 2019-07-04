package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Chat0;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository0 extends JpaRepository<Chat0, Long>{
    Chat0 findByAlias(String alias);
}
