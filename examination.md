# Gruppuppgift: Hotellbokningssystem

### Bakgrund
Ni ska som team bygga ett robust API för ett hotell. Ni ska använda **Spring Boot** och **Spring Security (JWT)**. Eftersom ingen databas används i detta skede ska ni använda lagring i minnet (In-memory).

---

## Nivå 1: Basfunktionalitet (Grundkrav för gruppen)

### 1. Avancerad Modellering
För att hålla en god arkitektur får ni inte använda samma klass för inkommande data och det som lagras i systemet.
* **BookingRequest:** Innehåller gästinfo, antal gäster, rumstyp och antal nätter.
* **BookingResponse:** Innehåller bokningsnummer, sammanställd prisinfo och status.
* **Affärslogik:** En bokning måste valideras. Om man bokar för fler gäster än rumstypen tillåter ska systemet kasta ett fel.
    * *Enkelrum:* Max 1 gäst
    * *Dubbelrum:* Max 2 gäster
    * *Svit:* Max 3 gäster

### 2. Service-lager med Tillståndskontroll
Hotellet har en begränsad kapacitet på **20 rum**.
* Systemet måste hålla ordning på hur många rum av varje typ som finns (t.ex. 10 enkelrum, 7 dubbelrum, 3 sviter).
* Om en rumstyp som är slut bokas ska ett tydligt felmeddelande returneras (**400 Bad Request**).

### 3. Säkerhet
Implementera JWT-säkerhet där ni skiljer på vad olika användare kan göra (Role-Based Access Control):
* **ROLE_USER (Gäst):** Kan skapa en bokning och se sin egen bekräftelse.
* **ROLE_ADMIN (Receptionist):** Kan lista alla bokningar, söka på bokningsnummer och radera bokningar.

### 4. Global Felhantering
Ni måste implementera en `@ControllerAdvice` som fångar upp och returnerar standardiserade svar för:
* `AuthenticationException` (fel inloggning).
* `IllegalArgumentException` (t.ex. för många gäster för rumstypen).
* Ett eget skapat `OutOfRoomsException`.

---

## Nivå 2: Frivillig Utmaning

### A. Sök- och filtreringsfunktion
Skapa en endpoint för receptionisten där man kan filtrera bokningar baserat på rumstyp eller gästens namn.

### B. Tidsbaserad logik och "Double Booking"-skydd
Implementera fält för `incheckningsDatum` och `utcheckningsDatum` (använd `LocalDate`).
* **Validering:** Systemet ska neka en bokning om incheckningsdatumet är efter utcheckningsdatumet, eller om datumet ligger bakåt i tiden.
* **Krock-kontroll (Avancerat):** Innan en bokning sparas måste systemet kontrollera att det specifika rummet inte redan är upptaget under den valda perioden. En ny bokning får inte överlappa med en befintlig.

### C. Dynamisk prisberäkning med nätter
Istället för ett fast pris, låt systemet räkna ut den totala summan baserat på antalet nätter.
* **Logik:** Totalpris beräknas som $$Pris \text{ per natt} \times \text{Antal nätter}$$
* **Extra krydda:** Implementera "Helgtillägg" – om en bokning inkluderar en fredag eller lördag natt ökar priset med 20% för dessa specifika nätter.

---

## Inlämningskrav (Tekniskt)

* **Kodkvalitet:** Ingen affärslogik i Controllers. All beräkning av pris och validering av gäster ska ligga i Services.
* **Dokumentation:** En kort `README.md` i ert projekt som förklarar hur man loggar in och vilka endpoints som finns tillgängliga.