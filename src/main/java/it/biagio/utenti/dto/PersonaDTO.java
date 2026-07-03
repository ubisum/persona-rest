package it.biagio.utenti.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {

    private String nome;
    private String cognome;
    private String dataNascita;   // formato: yyyy-MM-dd
    private String codiceFiscale;
    private String cittaNascita;
    private String provincia;
}