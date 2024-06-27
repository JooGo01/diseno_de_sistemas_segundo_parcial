package ar.edu.davinci.parcial.model;

public enum Tipo {

    Eléctrico, Agua, Fuego, Vegetal, Piedra;
    public static boolean existe(String value) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static Tipo fromString(String value) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Enum no encontrado con valor " + value);
    }
}
