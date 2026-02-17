package se.grupp3.hotellbokningssystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import se.grupp3.hotellbokningssystem.model.RoomType;


public class BookingRequest {

    @NotBlank(message = "Guest name is required.")
    private String guestName;

    @NotNull(message = "Guest count is required.")
    @Min(value = 1, message = "Guest count must be at least 1.")
    private Integer guestCount;

    @NotNull(message = "Room type is required")
    private RoomType roomType;

    @NotNull(message = "Nights is required.")
    @Min(value = 1, message = "Nights must be at least 1")
    private Integer nights;

    public BookingRequest() {
    }

    public BookingRequest(String guestName, Integer guestCount, RoomType roomType, Integer nights) {
        this.guestName = guestName;
        this.guestCount = guestCount;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
}
