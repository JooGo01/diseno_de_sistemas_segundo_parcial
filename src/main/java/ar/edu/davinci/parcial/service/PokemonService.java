package ar.edu.davinci.parcial.service;

import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/pokemon")
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @PostMapping(value="/",  consumes = {"application/json", "application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
    public Optional<Pokemon> createPokemon(Pokemon pokemon){
        pokemonRepository.save(pokemon);
        return null;
    }

    @GetMapping("/")
    public List<Pokemon> findAll(){
        List<Pokemon> pokemones = new ArrayList<>();
        pokemones=pokemonRepository.findAll();
        return pokemones;
    }

    @GetMapping("/busqueda/id/{id}")
    public Optional<Pokemon> findById(Long id){
        return pokemonRepository.findById(id);
    }
}
