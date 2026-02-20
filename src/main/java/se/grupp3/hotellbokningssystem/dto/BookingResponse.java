package se.grupp3.hotellbokningssystem.dto;

import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;

import java.time.LocalDate;

public class BookingResponse {
    private Integer bookingNumber;
    private String guestName;
    private String roomType;
    private Integer roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer totalPrice;
    private BookingStatus status;

    public BookingResponse() {
    }

    public BookingResponse(Integer bookingNumber, Integer totalPrice, BookingStatus status) {
        this.bookingNumber = bookingNumber;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public BookingResponse(Booking booking){
        this.bookingNumber = booking.getId();
        this.guestName = booking.getGuestName();
        this.roomType = booking.getRoomType().toString();
        this.roomNumber = booking.getRoomNumber();
        this.checkInDate = booking.getCheckInDate();
        this.checkOutDate = booking.getCheckOutDate();
        this.totalPrice = booking.getTotalPrice();
        this.status = booking.getStatus();
    }

    public Integer getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Integer bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getGuestName() { return guestName; }

    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getRoomType() { return roomType; }

    public void setRoomType(String roomType) { this.roomType = roomType; }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
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

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
