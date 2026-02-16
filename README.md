# Hotellbokningssystem

# Projektstruktur (Träd)
Här är en översikt över filerna 


├── HotelApplication.java       (Startpunkten)
├── controller                  (Tar emot anrop)
│   ├── AuthController.java
│   └── BookingController.java
├── service                     (Gör jobbet)
│   ├── BookingService.java
│   └── CustomUserDetailsService.java
├── repository                  (Sparar data)
│   └── BookingRepository.java
├── model                       (Dataklasser)
│   ├── Booking.java
│   ├── BookingStatus.java
│   └── RoomType.java
├── dto                         (Paket för transport)
│   ├── AuthRequest.java
│   ├── AuthResponse.java
│   ├── BookingRequest.java
│   └── BookingResponse.java
├── security                    (Säkerhet & Login)
│   ├── JwtAuthenticationFilter.java
│   ├── JwtUtil.java
│   └── SecurityConfig.java
└── exception                   (Felhantering)
├── GlobalExceptionHandler.java
└── OutOfRoomsException.java




