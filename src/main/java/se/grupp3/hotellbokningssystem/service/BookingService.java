package se.grupp3.hotellbokningssystem.service;

import org.springframework.stereotype.Service;
import se.grupp3.hotellbokningssystem.exception.OutOfRoomsException;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;
import se.grupp3.hotellbokningssystem.repository.BookingRepository;

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
        if(this.bookingRepository.getNrOfBookedRooms(roomType) >= roomType.getNrOfRooms()){
            throw new OutOfRoomsException(roomType);
        }

        if(guestCount > roomType.getMaxGuests()){
            throw new IllegalArgumentException("Too many guests for the selected room type");
        }

        Booking b = new Booking(null, guestName, guestCount, roomType, nights, roomType.getPricePerNight() * nights, BookingStatus.CONFIRMED);

        bookingRepository.addBooking(b);

        return b;
    }
}
