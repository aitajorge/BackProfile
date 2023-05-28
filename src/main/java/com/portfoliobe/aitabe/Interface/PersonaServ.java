package com.portfoliobe.aitabe.Interface;
 
import com.portfoliobe.aitabe.Logica.Persona;
import java.util.List;


public interface PersonaServ {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
