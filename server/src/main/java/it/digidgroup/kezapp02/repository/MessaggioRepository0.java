package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Messaggio0;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessaggioRepository0 
extends JpaRepository<Messaggio0, Long>{
    @Query("select m from Messaggio0 m"
            + " where (m.nickName = :nn)"
            + " or (m.nickName is null)")
    List<Messaggio0> trovaMessaggi(
            @Param("nn") String nickName);
}
