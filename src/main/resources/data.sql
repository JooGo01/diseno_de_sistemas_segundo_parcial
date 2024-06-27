CREATE TABLE IF NOT EXISTS entrenador(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    nacionalidad VARCHAR(255),
    genero VARCHAR(10),
    edad INT
)

CREATE TABLE IF NOT EXISTS tipo(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255)
)

CREATE TABLE IF NOT EXISTS pokemon(
    id INT PRIMARY KEY AUTO_INCREMENT,
    especie VARCHAR(255),
    vida DOUBLE,
    poder DOUBLE,
    tipo_id INT,
    FOREIGN KEY (tipo_id) REFERENCES artista(id)
)

CREATE TABLE IF NOT EXISTS pokemon_entrenador (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pokemon_id INT,
    entrenador_id INT,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (entrenador_id) REFERENCES entrenador(id)
);


INSERT INTO entrenador(nombre,nacionalidad,genero,edad)
VALUES ('Entrenador A', 'Brasil', 'Masculino', 30),
       ('Entrenadora B', 'Colombia', 'Femenino', 26)

INSERT INTO tipo (nombre)
VALUES ('Eléctrico'), ('Agua'), ('Fuego'), ('Vegetal'), ('Piedra');

INSERT INTO pokemon(especie,vida,poder,tipo_id)
VALUES ('Especie 1', 100, 20, 1),
       ('Especie 2', 80, 30, 3),
       ('Especie 3', 60, 40, 2),
       ('Especie 4', 80, 20, 5)