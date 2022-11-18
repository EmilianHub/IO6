package com.minutowka.io6.Repositories;

import com.minutowka.io6.DTO.DanePV;
import com.minutowka.io6.JPA.DanePVJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DanePVRepo extends JpaRepository<DanePVJPA,Long>{
    Optional<DanePVJPA> findByUzytkownikId(Long id);
}
