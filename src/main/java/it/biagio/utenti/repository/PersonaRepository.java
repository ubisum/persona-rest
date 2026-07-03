package it.biagio.utenti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.biagio.utenti.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    boolean existsByCodiceFiscale(String codiceFiscale);

    Optional<Persona> findByCodiceFiscale(String codiceFiscale);

}