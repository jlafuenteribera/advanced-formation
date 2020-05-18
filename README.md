# Formación Avanzada JAVA

[TOC]

## Transaccionalidad

### JDBC

Aqui tenemos 2 clases con 1 Main cada una.

* TransaccionJDBC:

 Este ejemplo falla (linea 41) hay que cambiar el nombre de la columna 'balanze' -> 'balance' Ninguno de los updates se persisten en BBDD debido a que se ejecutan mediante transacciones.

* TransaccionJDBC2:

 Este ejemplo falla (linea 40) hay que cambiar el nombre de la columna 'balanze' -> 'balance' El primer update se persiste en BBDD dado que las órdenes no se están ejecutando mediante transacciones.

### SPRING

Este ejemplo falla (linea 32) de la clase Application.java, hay que cambiar el nombre de la persona 'Juans' -> 'Juan'. Mientras la anotación @Transactional este en la funcion ninguno de los 2 cambios persistira en BBDD a no ser que los 2 sean correctos. Si se elimina @Transactional el primer update se persistirá siempre aunque el segundo falle.

## Microservicios

### Nodejs

Microservicio creado con NodeJS.

Para ejecutar:

`npm install`

`npm start`

### Spring-boot

Microservicio creado con Java.

Para ejecutar:

`mvn clean install spring-boot:run`

### Python

Microservicio creado con Python.

Para ejecutar:

`pip install`

`python3 app.py`

## Contenedores

### Imagenes

Imagenes contenedores docker creadas a partir de los microservicios del punto anterior.

Para ejecutar:

`docker create nombre_imagen`

### Docker-Compose

configuración docker-compose para levantar los 3 microservicios anteriores en 1 orden.

Para ejecutar:

`docker-compose up`
