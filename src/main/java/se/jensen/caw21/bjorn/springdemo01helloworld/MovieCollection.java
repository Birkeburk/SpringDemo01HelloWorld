package se.jensen.caw21.bjorn.springdemo01helloworld;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieCollection {
    private ArrayList<Movie> myMovies;

    public MovieCollection() {
        myMovies = new ArrayList<Movie>();
        Movie newMovie1 = new Movie("Men In Black", 9);
        Movie newMovie2 = new Movie("Men In Black 2", 8);
        addMovie(newMovie1);
        addMovie(newMovie2);
        System.out.println("[MovieCollection] Nu körs konstruktorn");
    }

    public void addMovie(Movie movie) {
        System.out.println("[MovieCollection] Lade till filmen " + movie.title);
        myMovies.add(movie);
    }

    public ArrayList<Movie> getMovies() {
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
        JsonArray arrayOfObjects = new JsonArray();

        for (int i = 0; i < myMovies.size(); i++) {
            JsonObject movieObject = new JsonObject();
            movieObject.put("title", myMovies.get(i).title);
            movieObject.put("rating", myMovies.get(i).rating);

            arrayOfObjects.add(movieObject);
        }

        // Skriv ut till vår consol, gör det lättare vid felsökning
        //System.out.println("[MovieCollection] Metod: movies(), RequestMapping: /movies, retunerar: " + jsonMovies);
        System.out.println("[MovieCollection] Metod: movies(), RequestMapping: /movies, retunerar: ");

        // Retunera objektet istället för strängen
        return arrayOfObjects;
    }

    // Lägg till nya filmer i listan med vårt API
    @RequestMapping("/api/add_movie")
    void apiAddMovie(@RequestBody Movie movie) {
        System.out.println("[MovieCollection] API: add_move: title:" + movie.title);
        addMovie(movie);
    }

    // Lägg till nya filmer i listan med vårt API
    @RequestMapping("/api/clear_movies")
    void apiClearMovies() {
        System.out.println("[MovieCollection] API: clear movies");
        myMovies.clear();
    }
}
