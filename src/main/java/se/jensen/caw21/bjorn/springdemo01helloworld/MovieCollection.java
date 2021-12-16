package se.jensen.caw21.bjorn.springdemo01helloworld;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieCollection {
    private ArrayList<String> myMovies;

    public MovieCollection() {
        myMovies = new ArrayList<String>();
        myMovies.add("Men In Black");
        myMovies.add("Men In Black 2");
        System.out.println("[MovieCollection] Nu körs konstruktorn");
    }

    public void addMovie(String title) {
        System.out.println("[MovieCollection] Lade till filmen " + title);
        myMovies.add(title);
    }

    public ArrayList<String> getMovies() {
        return myMovies;
    }

    //****** API-metoder ********//

    // TODO: Ta bort
    @RequestMapping("/api")
    JsonObject home() {
        JsonObject object = new JsonObject();

        object.put("message", "Hello World in JSON!");

        System.out.println("[MovieCollection] Metod: home(), RequestMapping: /, retunerar: " + object);

        // Retunera objektet istället för strängen
        return object;
    }

    // TODO: Ta bort denna metod och annan_sida.html
    @RequestMapping("/api/undersida")
    JsonObject undersida() {
        JsonObject object = new JsonObject();

        // Lägg till ett meddelande till objektet,
        // ungefär som med HashMaps i Java
        object.put("message", "Undersidan in JSON!");

        // Skriv ut till vår consol, gör det lättare vid felsökning
        System.out.println("[MovieCollection] Metod: undersida(), RequestMapping: /undersida, retunerar: " + object);

        // Retunera objektet istället för strängen
        return object;
    }

    // Retunera ett JSON-objekt med våra filmer
    @RequestMapping("/api/movies")
    JsonArray apiMovies() {
        // Skapa ett JSON-objekt
        JsonArray array = new JsonArray();

        for (int i = 0; i < myMovies.size(); i++) {
            array.add(myMovies.get(i));
        }

        // Skriv ut till vår consol, gör det lättare vid felsökning
        System.out.println("[MovieCollection] Metod: movies(), RequestMapping: /movies, retunerar: " + array);

        // Retunera objektet istället för strängen
        return array;
    }

    // Lägg till nya filmer i listan med vårt API
    @RequestMapping("/api/add_movie")
    void apiAddMovie(@RequestParam(required = false) String title) {
        System.out.println("[MovieCollection] API: add_move: title:" + title);
        addMovie(title);
    }

    // Lägg till nya filmer i listan med vårt API
    @RequestMapping("/api/clear_movies")
    void apiClearMovies() {
        System.out.println("[MovieCollection] API: clear movies");
        myMovies.clear();
    }
}
