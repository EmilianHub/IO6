package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.DaneKredytoweJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UzytkownikRepo extends JpaRepository<UzytkownikJPA, Long> {
    Optional<UzytkownikJPA> findByLogin(String login);
}
