package it.digidgroup.kezapp02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Messaggio02 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    @Column
    private String testo;
    @Column
    private String aliasDestinatario;
    @Column
    private String aliasMittente;
}
