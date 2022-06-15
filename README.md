# Escuela Colombiana de Ingeniería Julio Garavito

## Arquitecturas de Software (ARSW)

### :pushpin: Daniel Felipe Hernández Mancipe

<br/>

# :hammer_and_wrench: Networking Workshop

Proyecto con los ejercicios del taller de redes resuelto.

3.1 Escriba un programa en el cual usted cree un objeto URL e imprima en pantalla cada uno de los datos que retornan los 8 métodos de la sección anterior. [Ex31.java](/src/main/java/edu/escuelaing/arsw/labs/net/Ex31.java)

3.2 Escriba una aplicación browser que pregunte una dirección URL al usuario y que lea datos de esa dirección y que los almacene en un archivo con el nombre `resultado.html`. Luego intente ver este archivo en el navegador. [Ex32.java](/src/main/java/edu/escuelaing/arsw/labs/net/Ex32.java)

La página se puede ingresar como parámetro al momento de ejecutar dicha clase, y el archivo `resultado.html` queda en la carpeta raíz del proyecto.

![](../media/ex3.1witharg.png?raw=true)

También se puede ingresar la página de manera interactiva.

![](../media/ex3.1interactive.png?raw=true)

Vista desde el navegador:

![](../media/from_browser.png?raw=true)

**Nota :** En los ejercicios que lo requieren, se usa [EchoClient](/src/main/java/edu/escuelaing/arsw/labs/net/EchoClient.java) como cliente.

4.3.1 Escriba un servidor que reciba un número y responda el cuadrado de este número. [Ex431](/src/main/java/edu/escuelaing/arsw/labs/net/Ex431.java).

Primero se inicia a la izquierda el servidor:

![](../media/431.1.png?raw=true)

Luego se inicia a la derecha el cliente:

![](../media/431.2.png?raw=true)

Luego el cliente envía datos y recibe las respuestas:

![](../media/431.3.png?raw=true)

4.3.2 Escriba un servidor que pueda recibir un número y responda con un operación sobre este número. Este servidor puede recibir un mensaje que empiece por "fun:", si recibe este mensaje cambia la operación a las especificada. El servidor debe responder las funciones `seno`, `coseno` y `tangente`. Por defecto debe empezar calculando el `coseno`. Por ejemplo, si el primer número que recibe es 0, debe responder 1, si después recibe π/2 debe responder 0, si luego recibe “fun:sin” debe cambiar la operación actual a seno, es decir a a partir de ese momento debe calcular senos. Si enseguida recibe 0 debe responder 0. [Ex432](/src/main/java/edu/escuelaing/arsw/labs/net/Ex432.java)

![](../media/432.png?raw=true)

4.5.1 Escriba un servidor web que soporte múltiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo páginas html e imágenes. [HttpServer](/src/main/java/edu/escuelaing/arsw/labs/net/HttpServer.java)

![](../media/451.1.png?raw=true)

![](../media/451.2.png?raw=true)

![](../media/451.3.png?raw=true)

## Getting Started

### Prerequisites

- Java >= 11.x
- Maven >= 3.x
- Git >= 2.x
- JUnit 4.x

### Installing

Simplemente clone el repositorio:

```
git clone https://github.com/danielhndz/ARSW-networking-workshop.git
```

Luego compile el proyecto con maven:

```
mvn compile
```

Si salió bien, debería tener un **BUILD SUCCESS** verde.

### Using

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arsw.labs.net.<classname>"
```

El descripción del proyecto se encuentran casos de uso.

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [Git](https://git-scm.com/) - Version Management
- [JUnit4](https://junit.org/junit4/) - Unit testing framework for Java

## Authors

- **Daniel Hernández** - _Initial work_ - [danielhndz](https://github.com/danielhndz)

## License

This project is licensed under the GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details

## Javadoc

Para generar Javadocs independientes para el proyecto en la carpeta `/target/site/apidocs` ejecute:

```
mvn javadoc:javadoc
```
