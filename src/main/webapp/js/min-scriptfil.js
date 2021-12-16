// Vad skriver vi i den här filen då?
// En bra introduktion finns på W3School: https://www.w3schools.com/jquery/default.asp
// En dokumentation om allt som går att göra finns på https://jquery.com/

// OBS: Det här är inte en kurs i JavaScript. Det här är ingenting ni behöver
// ha stenkoll på för den här kursen, men jag tror det kan vara väldigt
// motiverande för flera av er, och därför har jag tagit med det här.
//
// OBS: JavaScript har inte speciellt mycket att göra med Java. Det är två helt
// olika programmeringsspråk.

// Om $(document).ready(): https://www.w3schools.com/jquery/jquery_syntax.asp
// Om $("button"), eller $("button#getMovies"): https://www.w3schools.com/jquery/jquery_selectors.asp

$(document).ready(function(){
  // Var ska information hämtas?
  // Observera att i JavaScript måste vi inte säga vad det är för sorts variabel.
  // (men det är fortfarande, ibland, skillnad på variabel="0" och variabel=0.)
  // (se videon Wat igen: https://www.youtube.com/watch?v=3se2-thqf-A)
  //
  $("button#clearMovies").click(function(){
    console.log("button#clearMovies pressed");

    $("ul#movies").empty();

    // Skicka en API-förfrågan till en metod som rensar listan av filmer
    $.post("/api/clear_movies", []);
  });

  $("button#getMovies").click(function(){
    console.log("button#getMovies pressed");

    $.get("/api/movies", function(data, status){
      $("ul#movies").empty();

      if (data.length == 0) {
        alert("Listan av filmer är tom!");
      }

      $.each(data, function(index, value) {
        console.log("Adding movie " + value + " to list");
        $("ul#movies").append("<li>" + index + ". " + value + "</li>");
      });
    });
  });

  $("button#alert").click(function(){
    console.log("button#alert pressed");

    $.get("/api/undersida", function(data, status){
      alert("En popup säger: " + data.message);
      alert("Så här såg internet ut förut.");
      alert("Och dessa rutor gav sig aldrig.");
      alert("Och flera tusen kunde komma upp på samma gång.");
      alert("Det var bättre förr.");
    });
  });

  // https://api.jquery.com/jQuery.post/
  $("button#addDummaMej").click(function (){
    $.post("/api/add_movie", { "title": "Dumma Mej" });
  })
});
