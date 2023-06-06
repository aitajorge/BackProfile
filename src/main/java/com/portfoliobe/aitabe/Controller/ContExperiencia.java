package com.portfoliobe.aitabe.Controller;

import com.portfoliobe.aitabe.DataTO.dtoExp;
import com.portfoliobe.aitabe.Logica.Experiencia;
import com.portfoliobe.aitabe.Servicio.ExperienciaServ;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ContExperiencia {
    @Autowired
    ExperienciaServ experienciaServ;

    public ContExperiencia() {
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }   


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExp dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje(""), HttpStatus.BAD_REQUEST);            
        
        if(experienciaServ.existsByNombreExp(dtoexp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexp.getNombreExp(), dtoexp.getDescripcionExp());
        experienciaServ.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        
      }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExp dtoexp) {
        if(!experienciaServ.existById(id))
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        
        if(experienciaServ.existsByNombreExp(dtoexp.getNombreExp()) && experienciaServ.getBynombreExp(dtoexp.getNombreExp()).get().getId() != id)
            return new  ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaServ.getOne(id).get();
        experiencia.setNombreExp(dtoexp.getNombreExp());
        experiencia.setDescripcionExp(dtoexp.getNombreExp());
        
        experienciaServ.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.BAD_REQUEST);       
        
    }
    
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaServ.existById(id))
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        experienciaServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);    }   
   
}   
    
    


