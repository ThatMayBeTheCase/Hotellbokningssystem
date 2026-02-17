package se.grupp3.hotellbokningssystem.dto;

import se.grupp3.hotellbokningssystem.model.Booking;
import se.grupp3.hotellbokningssystem.model.BookingStatus;

public class BookingResponse {
    private Integer bookingNumber;
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
        this.totalPrice = booking.getTotalPrice();
        this.status = booking.getStatus();
    }

    public Integer getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Integer bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

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
}
