package se.grupp3.hotellbokningssystem.repository;

import org.junit.jupiter.api.Test;
import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;
import se.grupp3.hotellbokningssystem.model.RoomType;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BookingRepositoryTests {
    @Test
    void noRoomsBooked_returnAllRoomsAvailable(){
        BookingRepository bookingRepository = new BookingRepository();

        assertArrayEquals(
                IntStream.range(1, RoomType.SUITE.getNrOfRooms() + 1).toArray(),
                bookingRepository.getAvailableRooms(LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7), RoomType.SUITE)
        );
    }

    @Test
    void allRoomsBooked_returnNoRoomsAvailable(){
        BookingRepository bookingRepository = new BookingRepository();

        for(int i = 1; i < RoomType.SUITE.getNrOfRooms() + 1; i++){
            bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, i, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7)));
        }

        assertArrayEquals(
                new int[0],
                bookingRepository.getAvailableRooms(LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7), RoomType.SUITE)
        );
    }

    @Test
    void allRoomsBookedExceptOne_returnOneAvailableRoom(){
        BookingRepository bookingRepository = new BookingRepository();

        for(int i = 1; i < RoomType.SUITE.getNrOfRooms(); i++){
            bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, i, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7)));
        }

        assertArrayEquals(
                new int[] { RoomType.SUITE.getNrOfRooms() },
                bookingRepository.getAvailableRooms(LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7), RoomType.SUITE)
        );
    }

    @Test
    void ifBookingGapFits_returnOneAvailableRoom(){
        BookingRepository bookingRepository = new BookingRepository();

        bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, 1, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 3)));
        bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, 1, LocalDate.of(2030, 1, 5), LocalDate.of(2030, 1, 7)));

        for(int i = 2; i < RoomType.SUITE.getNrOfRooms() + 1; i++){
            bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, i, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7)));
        }

        assertArrayEquals(
                new int[] { 1 },
                bookingRepository.getAvailableRooms(LocalDate.of(2030, 1, 3), LocalDate.of(2030, 1, 5), RoomType.SUITE)
        );
    }

    @Test
    void ifBookingGapIsTooSmall_returnNoAvailableRooms(){
        BookingRepository bookingRepository = new BookingRepository();

        bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, 1, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 3)));
        bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, 1, LocalDate.of(2030, 1, 5), LocalDate.of(2030, 1, 7)));

        for(int i = 2; i < RoomType.SUITE.getNrOfRooms() + 1; i++){
            bookingRepository.addBooking(new Booking(null, "user", "test", 1, RoomType.SUITE, 1, BookingStatus.CONFIRMED, i, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 1, 7)));
        }

        assertArrayEquals(
                new int[0],
                bookingRepository.getAvailableRooms(LocalDate.of(2030, 1, 2), LocalDate.of(2030, 1, 6), RoomType.SUITE)
        );
    }
}
