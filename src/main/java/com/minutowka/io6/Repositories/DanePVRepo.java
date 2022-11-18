package com.minutowka.io6.Repositories;

import com.minutowka.io6.DTO.DanePV;
import com.minutowka.io6.JPA.DanePVJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanePVRepo extends JpaRepository<DanePVJPA,Long>{
    DanePVJPA findByUzytkownikId(Long id);
}
