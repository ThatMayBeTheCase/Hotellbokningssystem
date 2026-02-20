package se.grupp3.hotellbokningssystem.service;

import org.junit.jupiter.api.Test;
import se.grupp3.hotellbokningssystem.model.RoomType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {
    @Test
    void validateGuestCount_allowsValidGuestCount() {
        assertDoesNotThrow(() -> BookingService.validateGuestCount(RoomType.SINGLE, 1));
    }

    @Test
    void validateGuestCount_throwsForTooManyGuestsInSingle() {
        assertThrows(IllegalArgumentException.class, () -> BookingService.validateGuestCount(RoomType.SINGLE, 2));
    }

    @Test
    void validateGuestCount_throwsForTooManyGuestsInDouble() {
        assertThrows(IllegalArgumentException.class, () -> BookingService.validateGuestCount(RoomType.DOUBLE, 3));
    }

    @Test
    void validateGuestCount_throwsForTooManyGuestsInSuite() {
        assertThrows(IllegalArgumentException.class, () -> BookingService.validateGuestCount(RoomType.SUITE, 4));
    }

    @Test
    void calculateTotalPriceDuringWeekdays_returnsExpectedPrice() {
        // Interval contains only weekdays
        assertEquals(3000, BookingService.calculateTotalPrice(RoomType.SINGLE, LocalDate.of(2026, 2, 1), LocalDate.of(2026, 2, 4)));
    }

    @Test
    void calculateTotalPriceDuringWeekend_returnsExpectedPrice() {
        // Interval contains a weekend
        assertEquals(3400, BookingService.calculateTotalPrice(RoomType.SINGLE, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 4)));
    }
}
