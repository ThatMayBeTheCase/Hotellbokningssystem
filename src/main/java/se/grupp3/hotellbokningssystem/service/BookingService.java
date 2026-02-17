package se.grupp3.hotellbokningssystem.service;

import org.springframework.stereotype.Service;
import se.grupp3.hotellbokningssystem.exception.OutOfRoomsException;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;
import se.grupp3.hotellbokningssystem.repository.BookingRepository;
import se.grupp3.hotellbokningssystem.exception.BookingNotFoundException;


import java.util.Collection;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public Collection<Booking> getBookings(){
        return this.bookingRepository.getBookings();
    }

    public Booking createBooking(String guestName, Integer nights, Integer guestCount, RoomType roomType) throws IllegalArgumentException, OutOfRoomsException {
        validateGuestCount(roomType, guestCount);

        if(this.bookingRepository.getNrOfBookedRooms(roomType) >= roomType.getNrOfRooms()){
            throw new OutOfRoomsException(roomType);
        }

        Booking b = new Booking(null, guestName, guestCount, roomType, nights, calculateTotalPrice(roomType, nights), BookingStatus.CONFIRMED);

        bookingRepository.addBooking(b);

        return b;
    }

    public static void validateGuestCount(RoomType roomType, Integer guestCount) {
        if (roomType == null) {
            throw new IllegalArgumentException("Room type is required.");
        }

        if (guestCount == null || guestCount < 1) {
            throw new IllegalArgumentException("Guest count must be at least 1.");
        }

        if (guestCount > roomType.getMaxGuests()) {
            throw new IllegalArgumentException("Too many guests for room type " + roomType + ". Max allowed: " + roomType.getMaxGuests());
        }
    }

    public static Integer calculateTotalPrice(RoomType roomType, Integer nights) {
        if (roomType == null) {
            throw new IllegalArgumentException("Room type is required.");
        }

        if (nights == null || nights < 1) {
            throw new IllegalArgumentException("Nights must be at least 1.");
        }

        return roomType.getPricePerNight() * nights;
    }

    public void deleteBooking(String id) {
        Booking booking = bookingRepository.getBookingById(id);
            if (booking == null) {
                throw new BookingNotFoundException("Booking with id " + id + " not found.");
            }
            bookingRepository.removeBooking(id);
    }
}
