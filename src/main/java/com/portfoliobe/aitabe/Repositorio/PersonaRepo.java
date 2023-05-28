package com.portfoliobe.aitabe.Repositorio;

import com.portfoliobe.aitabe.Logica.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,Long> {
    
}
