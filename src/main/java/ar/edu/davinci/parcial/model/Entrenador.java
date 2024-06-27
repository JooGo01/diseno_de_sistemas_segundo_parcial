package ar.edu.davinci.parcial.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nombre;
    Date fechaNacimiento;
    String nacionalidad;
    String genero;
    Integer edad;

    @ManyToMany
    @JoinTable(
            name = "pokemon_entrenador",
            joinColumns = @JoinColumn(name = "entrenador_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    @JsonManagedReference
    List<Pokemon> pokemons = new ArrayList<>();

    public Entrenador(){

    }

    public Entrenador(String nombre, Date fechaNacimiento, String nacionalidad, String genero, int edad, List<Pokemon> pokemons){
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        this.nacionalidad=nacionalidad;
        this.genero=genero;
        this.edad=edad;
        this.pokemons =pokemons;
    }

    private void enfrentarseA(Entrenador otroEntrenador){
        //falto llenar la logica de enfrentamiento
    }

    private void capturarPokemon(Pokemon unPokemon){
        if(pokemons.size()<5){
            pokemons.add(unPokemon);
        }else{
            System.out.println("Espacio lleno");
        }
    }

    private String getNombre(){
        return nombre;
    }
    private void setNombre(String nombre){
        this.nombre=nombre;
    }

    private Date getFechaNacimiento(){
        return fechaNacimiento;
    }
    private void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }
    private String getNacionalidad(){
        return nacionalidad;
    }
    private void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }

    private String getGenero(){
        return genero;
    }

    private void setGenero(String genero){
        this.genero=genero;
    }

    private Integer getEdad(){
        return edad;
    }

    private void setEdad(int edad){
        this.edad=edad;
    }

    private List<Pokemon> getPokemons(){
        return pokemons;
    }

    private void setPokemons(List<Pokemon> pokemons){
        this.pokemons=pokemons;
    }
}
