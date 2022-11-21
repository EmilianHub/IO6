package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.WplataJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface WplataRepo extends JpaRepository<WplataJPA, Long> {

    Collection<WplataJPA> findByPozyczkaIdOrderByCreatedDesc(Long id);
}
