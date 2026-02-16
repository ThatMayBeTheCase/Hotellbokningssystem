package se.grupp3.hotellbokningssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.grupp3.hotellbokningssystem.dto.BookingResponse;
import se.grupp3.hotellbokningssystem.service.BookingService;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("bookings/")
    public ResponseEntity<?> getBookings(){
        return ResponseEntity.ok(bookingService.getBookings().stream().map(BookingResponse::new));
    }
}
