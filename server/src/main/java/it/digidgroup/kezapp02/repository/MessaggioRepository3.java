package it.digidgroup.kezapp02.repository;


import it.digidgroup.kezapp02.model.Messaggio3;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessaggioRepository3 extends JpaRepository<Messaggio3, Long> {
    @Query("select m from Messaggio3 m"
            + " where (m.aliasDestinatario = :nn)"
            + " or (m.aliasDestinatario is null)")
    List<Messaggio3> trovaMessaggi(
            @Param("nn") String nickName);
}
