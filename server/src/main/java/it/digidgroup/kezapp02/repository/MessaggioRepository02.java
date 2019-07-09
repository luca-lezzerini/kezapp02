/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.digidgroup.kezapp02.repository;

import it.digidgroup.kezapp02.model.Messaggio02;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author utente
 */
public interface MessaggioRepository02 extends JpaRepository<Messaggio02, Long> {
    @Query("select m from Messaggio02 m"
            + " where (m.aliasDestinatario = :nn)"
            + " or (m.aliasDestinatario is null)")
    List<Messaggio02> trovaMessaggi(
            @Param("nn") String nickName);
}
