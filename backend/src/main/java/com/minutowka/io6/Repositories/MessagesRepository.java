package com.minutowka.io6.Repositories;

import com.minutowka.io6.JPA.MessagesJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<MessagesJPA, Long> {
}
