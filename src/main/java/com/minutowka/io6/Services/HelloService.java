package com.minutowka.io6.Services;

import com.minutowka.io6.Repositories.MessagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final MessagesRepository messagesRepository;

    public String getHelloMessage() {
        return messagesRepository.findAll().stream().findFirst().get().getWiadomosc();
    }
}
