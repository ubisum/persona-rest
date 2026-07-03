package it.biagio.utenti.dao;

import it.biagio.utenti.dto.PersonaDTO;

public interface PersonaDAO {

    boolean existsByCodiceFiscale(String codiceFiscale);

    void save(PersonaDTO dto);
}