package se.grupp3.hotellbokningssystem.service;

import org.junit.jupiter.api.Test;
import se.grupp3.hotellbokningssystem.model.RoomType;
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
    void calculateTotalPrice_returnsExpectedPrice() {
        assertEquals(3000, BookingService.calculateTotalPrice(RoomType.SINGLE, 3));
    }
}
