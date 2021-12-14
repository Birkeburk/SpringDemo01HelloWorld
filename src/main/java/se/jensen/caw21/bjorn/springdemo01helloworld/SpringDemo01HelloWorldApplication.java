package se.jensen.caw21.bjorn.springdemo01helloworld;

// Dessa kommer med per default med Spring Boot Initializer
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importera för att kunna skriva @RequestMapping längre ner
// Kräver import via Maven (pom.xml)
import org.springframework.web.bind.annotation.RequestMapping;

// RestController (och @RestController nedan) gör att innehållet i våra metoder kommer direkt till webbläsaren.
// Vad händer om du tar bort @RestController nedan...? Vad får du för felmeddelande?
import org.springframework.web.bind.annotation.RestController;

// Det här paketet låter oss skapa JSON-objekt på en enkelt sätt
// Läs mer om andra varianter här: https://cliftonlabs.github.io/json-simple/
// och mer lättläst här: https://cliftonlabs.github.io/json-simple/target/apidocs/index.html
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

// Läs mer här:
//   https://docs.spring.io/spring-boot/docs/1.1.4.RELEASE/reference/html/getting-started-first-application.html

@SpringBootApplication
@RestController
public class SpringDemo01HelloWorldApplication {

    // Dessa fyra rader har jag lagt in
    // Denna sida går att hitta på http://127.0.0.1:8080/
    // OBS: Uppdaterad return type från String till JSONObject
    @RequestMapping("/api")
    JsonObject home() {
      // Skapa ett JSON-objekt
      JsonObject object = new JsonObject();

      // Lägg till ett meddelande till objektet,
      // ungefär som med HashMaps i Java
      object.put("message", "Hello World in JSON!");

      // Skriv ut till vår consol, gör det lättare vid felsökning
      System.out.println("Metod: home(), RequestMapping: /, retunerar: " + object);

      // Retunera objektet istället för strängen
      return object;
    }

    // Dessa rader har jag också lagt in
    // Denna sida går att hitta på http://127.0.0.1:8080/undersida
    @RequestMapping("/api/undersida")
    JsonObject undersida() {
      JsonObject object = new JsonObject();

      // Lägg till ett meddelande till objektet,
      // ungefär som med HashMaps i Java
      object.put("message", "Undersidan in JSON!");

      // Skriv ut till vår consol, gör det lättare vid felsökning
      System.out.println("Metod: undersida(), RequestMapping: /undersida, retunerar: " + object);

      // Retunera objektet istället för strängen
      return object;
    }

    @RequestMapping("/api/movies")
    JsonArray movies() {
      // Skapa ett JSON-objekt
      JsonArray array = new JsonArray();

      array.add("Men In Black");
      array.add("Men In Black 2");
      array.add("Men In Black 3");

      // Skriv ut till vår consol, gör det lättare vid felsökning
      System.out.println("Metod: movies(), RequestMapping: /movies, retunerar: " + array);

      // Retunera objektet istället för strängen
      return array;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo01HelloWorldApplication.class, args);
    }

}
