package se.grupp3.hotellbokningssystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import se.grupp3.hotellbokningssystem.model.RoomType;

import java.time.LocalDate;


public class BookingRequest {

    @NotBlank(message = "Guest name is required.")
    private String guestName;

    @NotNull(message = "Guest count is required.")
    @Min(value = 1, message = "Guest count must be at least 1.")
    private Integer guestCount;

    @NotNull(message = "Room type is required")
    private RoomType roomType;

    @NotNull(message = "Check in date is required.")
    private LocalDate checkInDate;

    @NotNull(message = "Check out date is required.")
    private LocalDate checkOutDate;

    public BookingRequest() {
    }

    public BookingRequest(String guestName, Integer guestCount, RoomType roomType, LocalDate checkInDate, LocalDate checkOutDate) {
        this.guestName = guestName;
        this.guestCount = guestCount;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
