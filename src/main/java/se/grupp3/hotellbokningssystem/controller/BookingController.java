package se.grupp3.hotellbokningssystem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.grupp3.hotellbokningssystem.dto.BookingRequest;
import se.grupp3.hotellbokningssystem.dto.BookingResponse;
import se.grupp3.hotellbokningssystem.exception.OutOfRoomsException;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.service.BookingService;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<?> getBookings(){
        return ResponseEntity.ok(bookingService.getBookings().stream().map(BookingResponse::new));
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingRequest bookingRequest) throws Exception {
        Booking b = bookingService.createBooking(bookingRequest.getGuestName(), bookingRequest.getNights(), bookingRequest.getGuestCount(), bookingRequest.getRoomType());

        return ResponseEntity.status(HttpStatus.CREATED).body(new BookingResponse(b));
    }
}
