# HelloWorld i Spring

## Nytt med webben i denna branch

I den här grenen i git så har jag lagt in en hel del filer.

Dessa kommer från projekt som Bootstrap, JQuery, och diverse andra platser.

Se dessa filer och läs kommentarerna som står i dem:

* src/main/webapp/index.html
* src/main/webapp/css/min-stilfil.css
* src/main/webapp/js/min-scriptfil.js

Se som vanligt även LP och inspelad video för mer information.

Vill du köra detta i terminalen kan du göra så här:

    mvn compile
    mvn exec:java -Dexec.mainClass=se.jensen.caw21.bjorn.springdemo01helloworld.SpringDemo01HelloWorldApplication

## Nytt projekt

Det här är ett exempelprojekt av hur vi kan skriva en HelloWorld med Spring.

Vad jag gjort:

* Skapat ett nytt projekt i IntelliJ och valt att använda Spring Boot Initializer
* Lagt in en dependency i pom.xml
* Lagt till två metoder i java-filen under `src/main/java`
* ... med några extra importer och annoteringar. Dessa beskrivs i `src/main/java/se/jensen/caw21/bjorn/springdemo01helloworld/SpringDemo01HelloWorldApplication.java`

När du startar det här programmet kan du gå till följande sidor i din webbläsare:

* http://127.0.0.1:8080/
* http://127.0.0.1:8080/undersida

Om du går till en sida som inte finns får du ett felmeddelande. Testa att gå hit:

* http://127.0.0.1:8080/finnsinte

För mer detaljer se inspelad video och läs dokumentationen om Spring:

https://docs.spring.io/spring-boot/docs/1.1.4.RELEASE/reference/html/getting-started-first-application.html

## Felsökning, HTTP-koder och terminalen

Öppna din terminal (Ubuntu, git-bash eller Terminal på OSX) och testa använda programmet `curl`. Du kan behöva köra `apt install curl` i Ubuntu eller `homebrew install curl` på OSX).

Kom ihåg att dollartecknet bara är en indikator på att det som står efter det är något du kan skriva i terminalen. Står det `$ curl -s 127.0.0.1:8080` behöver du bara skriva `curl -s 127.0.0.1:8080` - alltså utan dollartecknet.

```
$ curl -s 127.0.0.1:8080
Hello World!
```

```
$ curl -s 127.0.0.1:8080/undersida
Hej igen! Nu på undersidan.
```

```
$ curl -s 127.0.0.1:8080/finnsej
{"timestamp":"2021-12-13T13:51:13.054+00:00","status":404,"error":"Not Found","path":"/finnsej"}
```

Det `-s` gör är "silent", att vi inte ser en progress bar om hur nedladdningen går. Testa gärna köra kommandot utan `-s`. Jag har använt det här för att den informationen mest skulle distrahera.

## HTTP-koder och annan HTTP-information

Det vi ser i våra exempel ovan är innehållet i sidan. Det vi oftast är intresserade av. Det är typ som själva meddelandet i ett mail. Men med mail så har vi även annan information, som exempelvis när det skickades eller från vem. Liknande information finns för HTTP, och detta kallas för "headers" och är metadata - alltså data om vår data.

Om vi använder `curl` med `-I` så får vi se header-information.

Här är samma kommandon som tidigare men med `-I`:

```
$ curl -I -s 127.0.0.1:8080
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 12
Date: Mon, 13 Dec 2021 14:00:51 GMT
```

Här ser vi att protokollet är HTTP, version 1.1. `200` är vår statuskod (se nedan). Vi kan även se `Content-Type`, `Content-Length` och vilket datum informationen skapades.

```
$ curl -I -s 127.0.0.1:8080/undersida
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 28
Date: Mon, 13 Dec 2021 14:01:08 GMT
```

Samma som exemplet innan, men meddelandet är längre.

```
$ curl -I -s 127.0.0.1:8080/finnsej
HTTP/1.1 404
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 13 Dec 2021 14:01:28 GMT
```

Här var det stor skillnad från innan, när vi försökte ladda en sida som inte finns. De två viktigaste just nu är att statuskoden är `404` istället för `200`, och `Content-Type` är något annat.

## Statuskoder i HTTP

Mozilla har en bra sida om vad det finns för olika statuskoder och vad de används till. Läs igenom den sidan:

* https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

Du måste inte memorera alla, men att läsa igenom listan en gång ger dig en bra insikt om vad det finns för koder.

# Uppgifter

## Uppgift 1
Skapa ett nytt projekt precis som jag gjort ovan. Använd `curl`-kommandona och se om du får samma svar som jag fick.

Testa skapa några nya sidor (metoder) och se om du kan få dem att fungera också.

## Uppgift 2

Vad betyder statuskoden `418`?

# Se även

En bra källa för statuskoder är https://http.cat.
