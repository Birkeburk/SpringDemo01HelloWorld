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

// Läs mer här:
//   https://docs.spring.io/spring-boot/docs/1.1.4.RELEASE/reference/html/getting-started-first-application.html

@SpringBootApplication
@RestController
public class SpringDemo01HelloWorldApplication {

    // Dessa fyra rader har jag lagt in
    // Denna sida går att hitta på http://127.0.0.1:8080/
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    // Dessa rader har jag också lagt in
    // Denna sida går att hitta på http://127.0.0.1:8080/undersida
    @RequestMapping("/undersida")
    String undersida() {
        return "Hej igen! Nu på undersidan.";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo01HelloWorldApplication.class, args);
    }

}
