package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.PozyczkiJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PozyczkaRepo extends JpaRepository<PozyczkiJPA, Long> {

    Collection<PozyczkiJPA> findAllByUzytkownikId(Long id);
}
