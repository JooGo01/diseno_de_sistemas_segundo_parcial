package ar.edu.davinci.parcial.controller;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.service.EntrenadorService;
import ar.edu.davinci.parcial.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;
    @Autowired
    private PokemonService pokemonService;

    @PostMapping(value="/",  consumes = {"application/json", "application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
    public Optional<Entrenador> create(@RequestBody Map<String, Object> requestBody){
        String nombre = requestBody.get("nombre").toString();
        String fechaString = (String) requestBody.get("fechaNacimiento");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formatter.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();  // Manejar adecuadamente la excepción
        }
        String nacionalidad = requestBody.get("nacionalidad").toString();
        String genero = requestBody.get("genero").toString();
        Integer edad = Integer.parseInt(requestBody.get("edad").toString());
        Object pokemonObj = requestBody.get("pokemons");
        List<Pokemon> lista_pokemon = new ArrayList<>();
        if(pokemonObj instanceof List){
            List<Long> lista_id_pokemon = (List<Long>) pokemonObj;
            for(Long id_pokemon : lista_id_pokemon){
                Pokemon pokemon = new Pokemon();
                Optional<Pokemon> pokemonBuscado = pokemonService.findById(id_pokemon);
                if(pokemonBuscado.isPresent()){
                    lista_pokemon.add((pokemonBuscado.get()));
                }
            }
        }else if (pokemonObj instanceof Long){
            Long id_pokemon = Long.parseLong(pokemonObj.toString());
            Optional<Pokemon> pokemonBuscado = pokemonService.findById(id_pokemon);
            if(pokemonBuscado.isPresent()){
                lista_pokemon.add((pokemonBuscado.get()));
            }
        }
        Entrenador entrenador = new Entrenador(nombre, fechaNacimiento, nacionalidad, genero, edad, lista_pokemon);
        Optional<Entrenador> entrenadorCreado = entrenadorService.createEntrenador(entrenador);
        return entrenadorCreado;
    }

    @GetMapping("/")
    public List<Entrenador> findAll(){
        return entrenadorService.findAll();
    }

    @GetMapping("/busqueda/id/{id}")
    public Optional<Entrenador> findById(@PathVariable Long id){
        return entrenadorService.findById(id);
    }
}
