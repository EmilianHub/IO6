package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.PozyczkaJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PozyczkaRepo extends JpaRepository<PozyczkaJPA, Long> {

    Collection<PozyczkaJPA> findAllByUzytkownikId(Long id);
    Long countAllByUzytkownikId (Long id);
}
