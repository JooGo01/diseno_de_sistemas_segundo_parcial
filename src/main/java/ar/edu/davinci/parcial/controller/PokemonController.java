package ar.edu.davinci.parcial.controller;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.PokemonRepository;
import ar.edu.davinci.parcial.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @PostMapping(value="/",  consumes = {"application/json", "application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
    public Optional<Pokemon> create(@RequestBody Map<String, Object> requestBody){
        String tipo = requestBody.get("tipo").toString();
        String especie = requestBody.get("especie").toString();
        Float vida = Float.parseFloat(requestBody.get("vida").toString());
        Float poder = Float.parseFloat(requestBody.get("poder").toString());

        Pokemon pokemon = new Pokemon(tipo,especie,vida,poder);
        Optional<Pokemon> pokemonCreado = pokemonService.createPokemon(pokemon);
        return pokemonCreado;
    }

    @GetMapping("/")
    public List<Pokemon> findAll(){
        return pokemonService.findAll();
    }

    @GetMapping("/busqueda/id/{id}")
    public Optional<Pokemon> findById(@PathVariable Long id){
        return pokemonService.findById(id);
    }
}
