package se.grupp3.hotellbokningssystem.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import se.grupp3.hotellbokningssystem.dto.BookingResponse;
import se.grupp3.hotellbokningssystem.exception.OutOfRoomsException;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;
import se.grupp3.hotellbokningssystem.repository.BookingRepository;
import se.grupp3.hotellbokningssystem.exception.BookingNotFoundException;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;

        this.bookingRepository.addBooking(new Booking(null, "user", "A Testsson", 1, RoomType.SINGLE, 1, BookingStatus.CONFIRMED, 1, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 7)));
        this.bookingRepository.addBooking(new Booking(null, "user", "B Testsson", 1, RoomType.DOUBLE, 1, BookingStatus.CONFIRMED, 1, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 7)));
        this.bookingRepository.addBooking(new Booking(null, "user", "C Testsson", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED,  1, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 7)));

    }

    public Collection<Booking> getBookings(Authentication authentication){
        if(authentication.getAuthorities().stream().anyMatch(a -> Objects.equals(a.getAuthority(), "ROLE_ADMIN"))){
            return bookingRepository.getBookings();
        } else {
            return bookingRepository.getBookingsByUserName(authentication.getName());
        }
    }

    public Booking createBooking(Authentication authentication, String guestName, Integer guestCount, RoomType roomType, LocalDate checkInDate, LocalDate checkOutDate) throws IllegalArgumentException, OutOfRoomsException {
        validateGuestCount(roomType, guestCount);
        validateDates(checkInDate, checkOutDate);

        int[] availableRooms = bookingRepository.getAvailableRooms(checkInDate, checkOutDate, roomType);

        if(availableRooms.length == 0){
            throw new OutOfRoomsException(roomType);
        }

        int nrOfNights = (int) (checkOutDate.toEpochDay() - checkInDate.toEpochDay());

        Booking b = new Booking(null, authentication.getName(), guestName, guestCount, roomType, calculateTotalPrice(roomType, nrOfNights), BookingStatus.CONFIRMED, availableRooms[0], checkInDate, checkOutDate);

        bookingRepository.addBooking(b);

        return b;
    }

    public void deleteBooking(int id) {
        Booking booking = bookingRepository.getBookingById(id);

        if (booking == null) {
            throw new BookingNotFoundException("Booking with id " + id + " not found");
        }

        bookingRepository.deleteBooking(id);
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

    public static Integer calculateTotalPrice(RoomType roomType, int nights) {
        if (roomType == null) {
            throw new IllegalArgumentException("Room type is required.");
        }

        if (nights < 1) {
            throw new IllegalArgumentException("Nights must be at least 1.");
        }

        return roomType.getPricePerNight() * nights;
    }

    public static void validateDates(LocalDate checkInDate, LocalDate checkOutDate){
        if(checkInDate == null){
            throw new IllegalArgumentException("The check in date is required.");
        }

        if(checkOutDate == null){
            throw new IllegalArgumentException("The check out date is required.");
        }

        if(checkInDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The check in date must not be before the current date.");
        }

        if(!checkInDate.isBefore(checkOutDate)){
            throw new IllegalArgumentException("The check out date must be after the check in date.");
        }
    }

    public BookingResponse getBookingById(Integer id) {
        Booking booking = bookingRepository.getBookingById(id);

        if (booking == null) {
            throw new BookingNotFoundException("Booking with id " + id + " not found");
        }

        return new BookingResponse(booking);
    }
}
