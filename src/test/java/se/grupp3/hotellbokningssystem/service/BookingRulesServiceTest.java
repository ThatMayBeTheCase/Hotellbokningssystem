package se.grupp3.hotellbokningssystem.service;

import org.junit.jupiter.api.Test;
import se.grupp3.hotellbokningssystem.model.RoomType;
import static org.junit.jupiter.api.Assertions.*;

public class BookingRulesServiceTest {

    private final BookingRulesService service = new BookingRulesService();

    @Test
    void validateGuestCount_allowsValidGuestCount() {
        assertDoesNotThrow(() -> service.validateGuestCount(RoomType.SINGLE, 1));
    }

    @Test
    void validateGuestCount_throwsForTooManyGuestsInSingle() {
        assertThrows(IllegalArgumentException.class, () -> service.validateGuestCount(RoomType.SINGLE, 2));
    }

    @Test
    void validateGuestCount_throwsForTooManyGuestsInDouble() {
        assertThrows(IllegalArgumentException.class, () -> service.validateGuestCount(RoomType.DOUBLE, 3));
    }

    @Test
    void validateGuestCount_throwsForTooManyGuestsInSuite() {
        assertThrows(IllegalArgumentException.class, () -> service.validateGuestCount(RoomType.SUITE, 4));
    }

    @Test
    void calculateTotalPrice_returnsExpectedPrice() {
        assertEquals(3000, service.calculateTotalPrice(RoomType.SINGLE, 3));
    }
}
