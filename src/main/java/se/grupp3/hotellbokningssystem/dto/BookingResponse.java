package se.grupp3.hotellbokningssystem.dto;

import se.grupp3.hotellbokningssystem.model.Booking;

public class BookingResponse {
    private int id;

    public BookingResponse(Booking booking){
        this.id = booking.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
