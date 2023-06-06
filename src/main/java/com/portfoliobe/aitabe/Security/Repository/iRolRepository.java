package com.portfoliobe.aitabe.Security.Repository;

import com.portfoliobe.aitabe.Security.Entity.Rol;
import com.portfoliobe.aitabe.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
