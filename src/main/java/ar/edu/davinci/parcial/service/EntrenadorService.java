package ar.edu.davinci.parcial.service;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Optional<Entrenador> createEntrenador(Entrenador entrenador){
        entrenadorRepository.save(entrenador);
        return null;
    }

    public List<Entrenador> findAll(){
        List<Entrenador> entrenadores = new ArrayList<>();
        entrenadores=entrenadorRepository.findAll();
        return  entrenadores;
    }

    public Optional<Entrenador> findById(Long id){
        return entrenadorRepository.findById(id);
    }
}
