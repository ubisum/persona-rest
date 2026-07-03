package it.biagio.utenti.dao;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import it.biagio.utenti.dto.PersonaDTO;
import it.biagio.utenti.entities.Persona;
import it.biagio.utenti.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonaDAOImpl implements PersonaDAO {

    private final PersonaRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public boolean existsByCodiceFiscale(String codiceFiscale) {
        return repository.existsByCodiceFiscale(codiceFiscale);
    }

    @Override
    public void save(PersonaDTO dto) {

        Persona persona = modelMapper.map(dto, Persona.class);

        // fix per campo data (perché DTO ha String)
        persona.setDataNascita(LocalDate.parse(dto.getDataNascita()));

        repository.save(persona);
    }
}