# Formación Avanzada JAVA

* [Transaccionalidad](#Transaccionalidad)
  * [JDBC](#JDBC)
  * [Spring](#Spring)
* [Microservicios](#Microservicios)
  * [Nodejs](#Nodejs)
  * [Spring Boot](#Spring-Boot)
  * [Python](#Python)
* [Contenedores](#installation)
  * [Angular Docker](#Angular-Docker)
  * [Spring Boot Docker](#Spring-Boot-Docker)
  * [Nodejs Docker](#Nodejs-Docker)
  * [Python Docker](#Python-Docker)
  * [Portainer](#Portainer)
  * [Liferay](#Liferay)
  * [Nexus](#Nexus)
  * [Docker-Compose](#Docker-Compose)

## Transaccionalidad

Para estos ejemplos necesitaremos un PostgreSQL instalado en la máquina. El script de inicialización de la DB esta incluido en la carpeta.

### JDBC

Aqui tenemos 2 clases con 1 Main cada una.

* TransaccionJDBC:

 Este ejemplo falla (linea 41) hay que cambiar el nombre de la columna 'balanze' -> 'balance' Ninguno de los updates se persisten en BBDD debido a que se ejecutan mediante transacciones.

* TransaccionJDBC2:

 Este ejemplo falla (linea 40) hay que cambiar el nombre de la columna 'balanze' -> 'balance' El primer update se persiste en BBDD dado que las órdenes no se están ejecutando mediante transacciones.

### Spring

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

`pip install -r requirements.txt`

`python3 controller.py`

## Contenedores

### Angular Docker

Para crear la imagen es necesario instalar las dependencias y compilar el código:

`npm install`

`npm build`

Una vez compilado, se crea la imagen y se levanta el contenedor ( Accesible desde <http://localhost:8090> ):

`docker build -t jlafuente/angular .`

`docker run -p 8090:80 -d jlafuente/angular`

### Spring-Boot Docker

Para crear la imagen es necesario instalar las dependencias y compilar el código:

`mvn clean install package`

Una vez compilado, se crea la imagen y se levanta el contenedor ( Accesible desde <http://localhost:8080> ):

`docker build -t jlafuente/java .`

`docker run -p 8080:8080 -d jlafuente/java`

### Nodejs Docker

Para crear la imagen es necesario instalar las dependencias y compilar el código:

`npm install`

`npm build`

Una vez compilado, se crea la imagen y se levanta el contenedor ( Accesible desde <http://localhost:8081> ):

`docker build -t jlafuente/nodejs .`

`docker run -p 8081:8080 -d jlafuente/nodejs`

### Python Docker

Para crear la imagen y se levantar el contenedor ( Accesible desde <http://localhost:8082> ):

`docker build -t jlafuente/python .`

`docker run -p 8082:8080 -d jlafuente/python`

### Portainer

Para el Portainer se crea un volumen para conservar los datos de configuración:

`docker volume create portainer_data`

`docker run -d -p 8000:8000 -p 9000:9000 --name=portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer`

### Liferay

Para el Liferay se crea un volumen para conservar los datos de configuración:

`docker volume create liferay_data`

`docker run -d -p 7006:8080 --restart always --name Liferay_App -v liferay_data:/storage mdelapenya/liferay-portal`

### Nexus

Para el Nexus se crea un volumen para conservar los datos de configuración:

`docker volume create --name nexus_data`

`docker run -d -p 7001:8081 --name nexus --restart always -v nexus_data:/nexus-data sonatype/nexus3`

### Docker-Compose

Creación de los 4 contenedores anteriores ( Angular, Spring-Boot, Nodejs y Python ) en 1 orden.

Para ejecutar:

`docker-compose up`
