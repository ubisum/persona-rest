package it.biagio.utenti.service;

import it.biagio.utenti.dao.PersonaDAO;
import it.biagio.utenti.dto.PersonaDTO;
import it.biagio.utenti.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDAO personaDAO;

    @Override
    public void creaPersona(PersonaDTO dto) {

        // 1. Validazione campi null / vuoti
        if (isNullOrEmpty(dto.getNome()) ||
            isNullOrEmpty(dto.getCognome()) ||
            isNullOrEmpty(dto.getDataNascita()) ||
            isNullOrEmpty(dto.getCodiceFiscale()) ||
            isNullOrEmpty(dto.getCittaNascita()) ||
            isNullOrEmpty(dto.getProvincia())) {

            throw new IllegalArgumentException("Tutti i campi del DTO devono essere valorizzati");
        }

        // 2. Validazione provincia (2 caratteri)
        if (dto.getProvincia().length() != 2) {
            throw new IllegalArgumentException("La provincia deve avere esattamente 2 caratteri");
        }

        // 3. Check codice fiscale esistente
        if (personaDAO.existsByCodiceFiscale(dto.getCodiceFiscale())) {
            throw new IllegalArgumentException("Codice fiscale già associato ad una persona");
        }

        // 4. Persistenza
        personaDAO.save(dto);
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}