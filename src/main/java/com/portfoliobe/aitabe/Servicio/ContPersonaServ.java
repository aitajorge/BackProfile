package com.portfoliobe.aitabe.Servicio;

import com.portfoliobe.aitabe.Interface.PersonaServ;
import com.portfoliobe.aitabe.Logica.Persona;
import com.portfoliobe.aitabe.Repositorio.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContPersonaServ implements PersonaServ{
    @Autowired PersonaRepo personaRepo;
    
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = personaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepo.save( persona);
    }
    
    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }
    
    @Override
    public Persona findPersona(Long id) {
       Persona persona = personaRepo.findById(id).orElse(null);
       return persona;
    }
    
}
