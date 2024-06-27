package ar.edu.davinci.parcial.model;

public class Pokemon {
    Tipo tipo;
    String especie;
    Float vida;
    Float poder;

    public Pokemon(){
    }

    public Pokemon(Tipo tipo, String especie, Float vida, Float poder){
        this.tipo=tipo;
        this.especie=especie;
        this.vida=vida;
        this.poder=poder;
    }

    private void atacar(Pokemon otroPokemon){

    }

    private void restarVida(Float cant){
        this.vida-=cant;
    }

    private void aumentarVida(Float vida){
        this.vida+=vida;
    }

    private Tipo getTipo(){
        return tipo;
    }

    private void setTipo(Tipo tipo){
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
