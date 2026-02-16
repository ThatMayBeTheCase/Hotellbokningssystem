package se.grupp3.hotellbokningssystem.service;

import org.springframework.stereotype.Service;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getBookings(){
        return this.bookingRepository.getBookings();
    }
}
