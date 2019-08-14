# RETO QUIND DEVOPS

Bienvenidos al primer reto DevOps que les presenta quind!

En este reto pondremos a prueba sus capacidades de exploración,
conocimientos previos y conocimientos adquiridos en DevOps, Jenkins,
Integración continua y ciclo de vida de desarrollo de software.

## Descripción

En este reto ustedes deberan construir un pipeline de integración
continua a partir de este repositorio.

En este repositorio encontraran:
- Este README.
- Los archivos fuente para una aplicacion de consola de java.
- El Build script para la aplicacion de consola con gradle.
- Un Jenkinsfile esqueleto para la creación de su pipeline.

Se espera entonces que para el momento de terminar el desafio haya completado
la creacion de un pipeline con todos los pasos que se describen a continuación:
- Unit Tests
- Analisis estatico de codigo con sonarQube
- Espera de confirmacion de Quality Gates por parte de sonarQube
- Build de la aplicacion y archivamiento de el artefacto generado

Este pipeline debe ejecutarse correctamente, y la aplicacion resultar en un archivo
.jar el cual sea accesible desde jenkins.

De antemano vale la pena mencionar que la aplicacion posee algunos fallos,
y que estos de no resolverse no permitiran que el pipeline llegue a feliz termino
incluso si la declaracion de este se encuentra bien hecha.

Para la realización de este reto entonces deben realizar un fork de este repositorio
en su propia cuenta de GitHub y es sobre ese fork que realizaran las modificaciones necesarias.

La primera modificacion que deben realizar es al nombre del proyecto en el archivo
settings.gradle . El nombre puede ser algo como "AplicacionReto${Nombre}".

## Jenkins
Para este reto se ha habilitado una instancia de jenkins sobre la cual podran crear sus pipelines.
La URL para este jenkins es: [JENKINS](reto-jenkins.quind.tabcode.tech).

En este tambien deberan crear su job de jenkins con un nombre que los identifique
y deberan crearlo a partir de el job llamado BASE dentro de la carpeta RETO.

En el siguiente [LINK](https://stackoverflow.com/questions/23838259/how-do-i-clone-a-job-in-jenkins/40432731#40432731)
encontraran como crear el job como copia del existente. 

Para ingresar a jenkins debera usar sus credenciales de github.

## SonarQube

Para el reto tambien se ha habilitado una instancia de sonarQube la cual se
encuentra previamente configurada en nuestro ambiente de jenkins con el nombre de `sonarQube`.
Pueden acceder aqui a [SONARQUBE](reto-sonarqube.quind.tabcode.tech).

## Recursos Utiles

- Como hacerle fork a un repositorio en github: https://help.github.com/en/articles/fork-a-repo
- Sintaxis de un pipeline declarativo: https://jenkins.io/doc/book/pipeline/syntax/
- Documentacion de Sonarqube integracion con jenkins: https://docs.sonarqube.org/latest/analysis/scan/sonarscanner-for-jenkins/
