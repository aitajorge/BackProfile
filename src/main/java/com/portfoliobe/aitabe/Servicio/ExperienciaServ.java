package com.portfoliobe.aitabe.Servicio;

import com.portfoliobe.aitabe.Logica.Experiencia;
import com.portfoliobe.aitabe.Repositorio.ExperienciaRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaServ {
 @Autowired
 ExperienciaRepo experienciaRepo;
 
 public List<Experiencia> list() {
     return experienciaRepo.findAll();
 }
 
 public Optional<Experiencia> getOne(int id){
     return experienciaRepo.findById(id);
 }

 public Optional<Experiencia> getBynombreExp(String nombreExp){
     return experienciaRepo.findByNombreExp(nombreExp);
 } 
 
 public void save(Experiencia experi){
     experienciaRepo.save(experi);
 }
 
 public void delete(int id){
     experienciaRepo.deleteById(id);
 }
 
 public boolean existById(int id){
     return experienciaRepo.existsById(id);
 }
 
 public boolean existByNombreExp(String nombreExp){
     return experienciaRepo.existsByNombreExp(nombreExp);
 }

    public boolean existsByNombreExp(String nombreExp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
