package com.minutowka.io6.JPA;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "messages")
public class MessagesJPA {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String wiadomosc;
}
