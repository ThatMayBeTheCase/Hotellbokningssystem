package se.grupp3.hotellbokningssystem.repository;

import org.springframework.stereotype.Repository;
import se.grupp3.hotellbokningssystem.model.Booking;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
    private ArrayList<Booking> bookings;

    public BookingRepository(){
        bookings = new ArrayList<>();

        bookings.add(new Booking(0));
        bookings.add(new Booking(1));
        bookings.add(new Booking(2));
    }

    public List<Booking> getBookings(){
        return bookings;
    }
}
