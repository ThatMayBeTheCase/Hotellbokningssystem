

Förklaring av Diagrammet
Diagrammet följer den arkitekturen i Spring Boot:
Controller → Service → Repository → Model samt en separat del för Security .

1️⃣ Controller Layer (API-lagret)
Ansvar: Tar emot HTTP-anrop från klienten (t.ex. webbläsare eller frontend) och skickar vidare till rätt service.
Klasser:
* BookingController
    * Hanterar bokningsrelaterade endpoints (GET, POST, DELETE etc.)
    * Delegerar affärslogik till BookingService
* AuthController
    * Hanterar autentisering (login, registrering)
    * Anropar säkerhetsrelaterade tjänster
      📌 Viktigt: Controllers innehåller ingen affärslogik, de fungerar som en mellanhand mellan klient och service.

2️⃣ Service Layer (Affärslogik)
Ansvar: Innehåller systemets regler och logik.
Klasser:
* BookingService
    * Hanterar affärsregler (exempel: prissättning, validering av datum)
    * Kommunicerar med BookingRepository för att spara/hämta data
* CustomUserDetailsService
    * Hämtar användardata
    * Används av Spring Security för autentisering
      📌 Viktigt: Service-lagret är systemets “hjärna”.

3️⃣ Repository Layer (Dataåtkomst)
Ansvar: Hanterar lagring och hämtning av data.
Klass:
* BookingRepository
    * Sparar bokningar
    * I detta fall används minneslagring (ingen riktig databas)
      📌 Repository pratar direkt med databasen (eller minneslagring).

4️⃣ Security Layer (Säkerhet)
Ansvar: Skyddar API:t genom att kontrollera användare och tokens.
Klasser:
* JwtAuthenticationFilter
    * Fångar upp (interceptar) inkommande anrop
    * Kontrollerar JWT-token innan anropet får fortsätta
* JwtUtil
    * Skapar och validerar JWT-tokens
      📌 Säkerhetslagret ligger “utanför” flödet och skyddar alla endpoints.

5️⃣ Model (Datamodell)
Klass:
* Booking
    * Representerar en bokning
    * Innehåller data som t.ex.:
        * id
        * kundnamn
        * datum
        * pris
          📌 Modellen är den centrala entiteten som används genom hela systemet.

🔄 Systemets Flöde (Steg för steg)
1. Klienten skickar ett HTTP-anrop
2. JwtAuthenticationFilter kontrollerar säkerheten
3. Controller tar emot anropet
4. Service utför affärslogik
5. Repository sparar/hämtar data
6. Svar skickas tillbaka till klienten