package se.grupp3.hotellbokningssystem.repository;

import org.springframework.stereotype.Repository;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

@Repository
public class BookingRepository {
    private final ArrayList<Booking> bookings;
    private int nextId;

    public BookingRepository(){
        bookings = new ArrayList<>();
        nextId = 0;
    }

    public Collection<Booking> getBookings(){
        return bookings;
    }


    public Collection<Booking> getBookingsByUserName(String userName) {
        return bookings.stream().filter(b -> Objects.equals(b.getUserName(), userName)).toList();
    }

    public int[] getAvailableRooms(LocalDate checkinDate, LocalDate checkoutDate, RoomType roomType){
        var filteredBookings = bookings.stream()
                .filter(b -> b.getRoomType() == roomType)
                .filter(b -> b.getCheckInDate().isBefore(checkoutDate))
                .filter(b -> b.getCheckOutDate().isAfter(checkinDate))
                .toList();

        return IntStream.range(1, roomType.getNrOfRooms() + 1)
                .filter(i -> filteredBookings.stream().noneMatch(b -> b.getRoomNumber() == i))
                .toArray();
    }

    public void addBooking(Booking booking){
        booking.setId(nextId++);
        bookings.add(booking);
    }

    public long getNrOfBookedRooms(RoomType roomType){
        return bookings.stream().filter(b -> b.getRoomType() == roomType).count();
    }

    public Booking getBookingById(int id){
        return bookings.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void removeBooking(int id) {
        Booking booking = getBookingById(id);
        if (booking != null) {
            bookings.remove(booking);
        }
    }

    public void deleteBooking(int id) {
        removeBooking(id);
    }
}
