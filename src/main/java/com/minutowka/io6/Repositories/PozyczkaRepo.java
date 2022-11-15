package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.PozyczkiJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PozyczkaRepo extends JpaRepository<PozyczkiJPA, Long> {

}
