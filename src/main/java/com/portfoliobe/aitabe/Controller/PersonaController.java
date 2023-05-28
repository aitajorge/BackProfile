package com.portfoliobe.aitabe.Controller;

import com.portfoliobe.aitabe.Interface.PersonaServ;
import com.portfoliobe.aitabe.Logica.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired PersonaServ personaServ;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return personaServ.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        personaServ.savePersona(persona);
        return "La persona fue creada";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaServ.deletePersona(id);
        return "La persona fue eliminada";
    }
    
    // Envía del Front al Back
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){ 
        Persona persona = personaServ.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        personaServ.savePersona(persona);
        return persona;
    }
        
      
    }
