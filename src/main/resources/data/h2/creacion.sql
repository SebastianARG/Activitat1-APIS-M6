-- Archivo: creacion.sql
-- Este script crea la tabla ANIMAL en la base de datos

CREATE TABLE IF NOT EXISTS ANIMAL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    weight INT NOT NULL,
    species VARCHAR(255) NOT NULL
    );
