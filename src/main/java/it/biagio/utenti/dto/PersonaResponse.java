package it.biagio.utenti.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaResponse {

    private String esito;
    private String messaggio;
}