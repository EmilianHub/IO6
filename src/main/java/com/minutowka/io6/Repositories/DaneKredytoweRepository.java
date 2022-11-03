package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.DaneKredytoweJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DaneKredytoweRepository extends JpaRepository<DaneKredytoweJPA, Long> {
    Optional<DaneKredytoweJPA> findDaneKredytoweJPAByUzytkownikId(Long id);
}
