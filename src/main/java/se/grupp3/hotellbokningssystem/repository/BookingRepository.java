package se.grupp3.hotellbokningssystem.repository;

import org.springframework.stereotype.Repository;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
    private ArrayList<Booking> bookings;

    public BookingRepository(){
        bookings = new ArrayList<>();

        bookings.add(new Booking(0, "A Testsson", 1, RoomType.SINGLE, 1, 1, BookingStatus.CONFIRMED));
        bookings.add(new Booking(1, "B Testsson", 1, RoomType.DOUBLE, 1, 1, BookingStatus.CONFIRMED));
        bookings.add(new Booking(2, "C Testsson", 1, RoomType.SUITE, 1, 1, BookingStatus.CONFIRMED));
    }

    public List<Booking> getBookings(){
        return bookings;
    }
}
