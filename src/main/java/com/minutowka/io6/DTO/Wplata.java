package com.minutowka.io6.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wplata {
    private Long id;
    private LocalDateTime created;
    private Double kwotaWplaty;
    private Long nadPlata;
    private Long nieDoplata;
    private Pozyczka pozyczka;
}
