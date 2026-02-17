package se.grupp3.hotellbokningssystem.service;

import org.springframework.stereotype.Service;
import se.grupp3.hotellbokningssystem.model.RoomType;

@Service
public class BookingRulesService {

    public void validateGuestCount(RoomType roomType, Integer guestCount) {
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
}
