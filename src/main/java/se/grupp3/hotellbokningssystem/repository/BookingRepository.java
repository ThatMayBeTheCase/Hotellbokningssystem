package se.grupp3.hotellbokningssystem.repository;

import org.springframework.stereotype.Repository;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;

import java.util.*;

@Repository
public class BookingRepository {
    private final ArrayList<Booking> bookings;
    private int nextId;

    public BookingRepository(){
        bookings = new ArrayList<>();
        nextId = 0;

        this.addBooking(new Booking(null, "A Testsson", 1, RoomType.SINGLE, 1, 1, BookingStatus.CONFIRMED));
        this.addBooking(new Booking(null, "B Testsson", 1, RoomType.DOUBLE, 1, 1, BookingStatus.CONFIRMED));
        this.addBooking(new Booking(null, "C Testsson", 1, RoomType.SUITE, 1, 1, BookingStatus.CONFIRMED));
    }

    public Collection<Booking> getBookings(){
        return bookings;
    }

    public void addBooking(Booking booking){
        booking.setId(nextId++);
        bookings.add(booking);
    }

    public long getNrOfBookedRooms(RoomType roomType){
        return bookings.stream().filter(b -> b.getRoomType() == roomType).count();
    }

    public Booking getBookingById(String id){
        try {
            int numericId = Integer.parseInt(id);
            return bookings.stream()
                    .filter(b -> b.getId() == numericId)
                    .findFirst()
                    .orElse(null);
            }
        catch (NumberFormatException e) {
            return null; }
    }

    public void removeBooking(String id) {
        Booking booking = getBookingById(id);
            if (booking != null) {
                bookings.remove(booking);
            }
    }
}
