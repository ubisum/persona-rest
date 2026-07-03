package it.biagio.utenti.controller;

import it.biagio.utenti.dto.PersonaDTO;
import it.biagio.utenti.dto.PersonaResponse;
import it.biagio.utenti.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persone")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaResponse> creaPersona(@RequestBody PersonaDTO dto) {

        try {
            personaService.creaPersona(dto);

            return ResponseEntity.ok(
                    PersonaResponse.builder()
                            .esito("OK")
                            .messaggio("Persona inserita correttamente")
                            .build()
            );

        } catch (IllegalArgumentException ex) {

            // KO per errori di validazione o CF duplicato
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(PersonaResponse.builder()
                            .esito("KO")
                            .messaggio(ex.getMessage())
                            .build()
                    );

        } catch (Exception ex) {

            // errore generico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(PersonaResponse.builder()
                            .esito("KO")
                            .messaggio("Errore generico")
                            .build()
                    );
        }
    }
}