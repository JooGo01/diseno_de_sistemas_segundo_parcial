package ar.edu.davinci.parcial.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //me falto poner a tipo como un ENUM
    String tipo;
    String especie;
    Float vida;
    Float poder;

    @ManyToMany
    @JoinTable(
            name = "pokemon_entrenador",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "entrenador_id")
    )
    @JsonBackReference
    @JsonIgnore
    List<Entrenador> entrenadors = new ArrayList<>();

    public Pokemon(){
    }

    public Pokemon(String tipo, String especie, Float vida, Float poder){
        this.tipo=tipo;
        this.especie=especie;
        this.vida=vida;
        this.poder=poder;
    }

    private void atacar(Pokemon otroPokemon){
        Float max = 100.0F;
        Float min = 1.0F;
        Float range = max - min + 1;
        Float rand = (int)(Math.random() * range) + min;
        otroPokemon.restarVida(rand);
    }

    private void restarVida(Float cant){
        if((this.vida-cant)<=0.0F){
            this.vida= 0.0F;
        }else{
            this.vida-=cant;
        }
    }

    private void aumentarVida(Float vida){

        if((this.vida+vida)>=100.0F){
            this.vida= 100.0F;
        }else{
            this.vida+=vida;
        }
    }

    private String getTipo(){
        return tipo;
    }

    private void setTipo(String tipo){
        this.tipo=tipo;
    }

    private String getEspecie(){
        return especie;
    }

    private void setEspecie(String especie){
        this.especie=especie;
    }

    private Float getVida(){
        return vida;
    }

    private void setVida(Float vida){
        this.vida=vida;
    }

    private Float getPoder(){
        return poder;
    }

    private void setPoder(Float poder){
        this.poder=poder;
    }
}
