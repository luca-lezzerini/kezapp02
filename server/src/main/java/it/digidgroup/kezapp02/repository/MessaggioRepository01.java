package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Messaggio01;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessaggioRepository01 

    extends JpaRepository<Messaggio01, Long>

    {
        @Query("select m from Messaggio01 m"
            + " where (m.aliasDestinatario = :nn)"
            + " or (m.aliasDestinatario is null)")
    List<Messaggio01> trovaMessaggi(
            @Param("nn") String nickName);
}
