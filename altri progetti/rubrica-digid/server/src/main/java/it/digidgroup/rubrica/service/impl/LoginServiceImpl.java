package it.digidgroup.rubrica.service.impl;

import it.digidgroup.rubrica.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean checkLogin(String utente, String password) {
        if ((utente != null) && (password != null) 
                && (utente.equals("u")) && (password.equals("p"))) {
            return true;
        } else {
            return false;
        }
    }

}
