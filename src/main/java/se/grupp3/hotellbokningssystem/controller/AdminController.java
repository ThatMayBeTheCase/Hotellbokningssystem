package se.grupp3.hotellbokningssystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.grupp3.hotellbokningssystem.service.BookingService;

import java.util.Map;

@RestController
@RequestMapping("/admin/bookings")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final BookingService bookingService;

    public AdminController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);

        return ResponseEntity.ok(
                Map.of("message", "Booking with id " + id + " has been deleted.")
        );
    }
}

