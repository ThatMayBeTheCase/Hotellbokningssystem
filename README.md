# Hotellbokningssystem

Ett REST API för hotellbokningar byggt med Spring Boot, JWT-autentisering och rollbaserad åtkomstkontroll.

## Kom igång

**Starta applikationen:**
```bash
./mvnw spring-boot:run
```
Applikationen körs på: `http://localhost:8080`

##  Endpoints

| Metod | Endpoint | Beskrivning | Roll |
|-------|----------|-------------|------|
| POST | `/login` | Logga in och få JWT-token | Alla |
| GET | `/bookings` | Hämta alla bokningar | USER, ADMIN |
| POST | `/bookings` | Skapa ny bokning | USER |
| GET | `/bookings/{id}` | Hämta specifik bokning | ADMIN |
| DELETE | `/bookings/{id}` | Ta bort bokning | ADMIN |

## Endpoints länkar

http://localhost:8080/login
http://localhost:8080/bookings
http://localhost:8080/bookings/{id}

##  Inloggning

**Testanvändare:**
- `user1` / `111` (USER)
- `user2` / `111` (USER)
- `admin` / `111` (ADMIN)

**Logga in:**
POST / login

```json
{
  "username": "user1",
  "password": "111"
}
```
Använd token i header: `Authorization: Bearer {token}`



**Skapa bokning:**
POST / bookings
```json
{
  "guestName": "Anna Andersson",
  "guestCount": 2,
  "roomType": "DOUBLE",
  "checkInDate": "2026-03-01",
  "checkOutDate": "2026-03-04"
}
```

##  Projektstruktur

```
src/main/java/se/grupp3/hotellbokningssystem/
├── HotellbokningssystemApplication.java
├── controller/
│   ├── AuthController.java          # Login endpoint
│   └── BookingController.java       # Bokningsendpoints
├── service/
│   └── BookingService.java          # Bokningslogik
├── repository/
│   └── BookingRepository.java       # Bokningsdatabashantering
├── model/
│   ├── Booking.java                 # Bokningsentitet
│   ├── BookingStatus.java           # Status enum
│   └── RoomType.java                # Rumstyp enum
├── dto/
│   ├── AuthRequest.java             # Login request
│   ├── BookingRequest.java          # Bokningsrequest
│   └── BookingResponse.java         # Bokningsresponse
├── security/
│   ├── JwtAuthenticationFilter.java # JWT-filter
│   ├── JwtUtil.java                 # JWT-generering/validering
│   └── SecurityConfig.java          # Security-konfiguration
└── exception/
    ├── GlobalExceptionHandler.java  # Global felhantering
    ├── OutOfRoomsException.java     # Inga lediga rum
    └── BookingNotFoundException.java # Bokning ej hittad
```

