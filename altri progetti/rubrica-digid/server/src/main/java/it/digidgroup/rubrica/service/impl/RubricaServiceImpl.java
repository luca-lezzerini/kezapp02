package it.digidgroup.rubrica.service.impl;

import it.digidgroup.rubrica.model.Contatto;
import it.digidgroup.rubrica.repository.ContattoRepository;
import it.digidgroup.rubrica.service.RubricaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubricaServiceImpl implements RubricaService {

    @Autowired
    ContattoRepository cr;

    @Override
    @Transactional
    public int conta() {
        return (int) cr.count();
    }

    @Override
    @Transactional
    public List<Contatto> search(String criterio) {
        if ((criterio == null) || (criterio.trim().isEmpty())) {
            return cr.findAll();
        } else {
            criterio = "%" + criterio + "%";
            return cr.findByNomeLike(criterio);
        }
    }

    @Override
    @Transactional
    public List<Contatto> cancellaRubrica(Long id) {
        cr.deleteById(id);
        return trovaTutti();
    }

    @Override
    @Transactional
    public List<Contatto> aggiungiRubrica(Contatto contatto) {
        cr.save(contatto);
        return trovaTutti();
    }

    @Override
    @Transactional
    public List<Contatto> trovaTutti() {
        return search(null);
    }

}
