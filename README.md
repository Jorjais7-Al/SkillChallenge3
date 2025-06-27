Código que use para la base de datos:

CREATE DATABASE shopAll;
use shopAll;

CREATE TABLE peliculas (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre_pelicula VARCHAR(30) NOT NULL,
    disponible BOOLEAN NOT NULL
);

INSERT INTO peliculas (nombre_pelicula, disponible) VALUES ('Tarzan',1);
INSERT INTO peliculas (nombre_pelicula, disponible) VALUES ('Cars',1);
INSERT INTO peliculas (nombre_pelicula, disponible) VALUES ('Toy Story',1);
INSERT INTO peliculas (nombre_pelicula, disponible) VALUES ('Destino Final',0);
INSERT INTO peliculas (nombre_pelicula, disponible) VALUES ('Scary Movie',0);

SELECT * FROM peliculas; 
