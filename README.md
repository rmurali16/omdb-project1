# omdb-project1

## About
This Repository is a compilation of the coding exercises covered for API Testing using Rest Assured Library. 

More information in this webpage: <http://rest-assured.io/>

Rest Assured Github repository: <https://github.com/rest-assured/rest-assured>


## Pre-requisites:
* [Java 8 installed](https://www.toolsqa.com/selenium-webdriver/install-java/)
* Maven Installed : [Windows Installation](https://www.toolsqa.com/java/maven/how-to-install-maven-on-windows/) OR [Mac Installation](https://www.toolsqa.com/java/maven/how-to-install-maven-on-mac/)
* [Eclipse / IntelliJ IDE installed](https://www.toolsqa.com/mobile-automation/appium/install-eclipse-ide-and-set-up-a-project/) - IntelliJ preferred
* Create Maven project in IntelliJ -https://www.jetbrains.com/idea/guide/tutorials/working-with-maven/creating-a-project/
* Make sure you have TestNG, RestAssured downloaded and in the dependencies. 


## API
The API used for these classes to practice is based on very easy to use [OMDB API](https://www.omdbapi.com/).

### Endpoints

##### Account/Authentication
API key generated from omdbapi.com

##### Query Params
* **GET**  ?i=imdbId
* **GET**  ?s=searchtitle
* **GET**  ?t=titleofthemovie

## Framework
I utilized TestNG with RestAssured couples with Maven
### Structure

This project is a standard Maven Java project with src folders and pom.xml

### Tests

`src/test/java/` package contains all the tests requested as part of the coding exerise.

### Installation
`mvn clean install` To install the project 
and To run the test make sure you have `mvn clean test`

## Help
If you have any questions, please feel free to contact me
