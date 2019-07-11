package it.digidgroup.rubrica.controller;

import it.digidgroup.rubrica.dto.CredenzialiDto;
import it.digidgroup.rubrica.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @RequestMapping(value={"/checkLogin"})
    @ResponseBody
    public boolean checkLogin(@RequestBody CredenzialiDto cred){
        return loginService.checkLogin(
                cred.getUtente(), 
                cred.getPassword());
    }
}
