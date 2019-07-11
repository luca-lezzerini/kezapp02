package it.digidgroup.rubrica.controller;

import it.digidgroup.rubrica.dto.PrimaryKeyDto;
import it.digidgroup.rubrica.dto.SearchDto;
import it.digidgroup.rubrica.model.Contatto;
import it.digidgroup.rubrica.service.RubricaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RubricaController {

    @Autowired
    RubricaService rs;
    
    @RequestMapping(value={"/conta"})
    @ResponseBody
    public int conta(){
        return rs.conta();
    }
    
    @RequestMapping(value={"/search"})
    @ResponseBody
    public List<Contatto> search(@RequestBody SearchDto dto){
        return rs.search(dto.getCriterio());
    }
    
    @RequestMapping(value={"/cancellaRubrica"})
    @ResponseBody
    public List<Contatto> cancellaRubrica(@RequestBody PrimaryKeyDto dto){
        return rs.cancellaRubrica(dto.getId());
    }
    
    @RequestMapping(value={"/aggiungiRubrica"})
    @ResponseBody
    public List<Contatto> aggiungiRubrica(@RequestBody Contatto cont){
        return rs.aggiungiRubrica(cont);
    }
    
    @RequestMapping(value={"/mainPage"})
    @ResponseBody
    public List<Contatto> mainPage(){
        return rs.trovaTutti();
    }
    
    
    
    
}
