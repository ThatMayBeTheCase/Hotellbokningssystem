package se.grupp3.hotellbokningssystem.model;

public class Booking {
    private Integer id;
    private String guestName;
    private Integer guestCount;
    private RoomType roomType;
    private Integer nights;
    private Integer totalPrice;
    private BookingStatus status;

    public Booking() {
    }

    public Booking(Integer id, String guestName, Integer guestCount, RoomType roomType, Integer nights, Integer totalPrice, BookingStatus status) {
        this.id = id;
        this.guestName = guestName;
        this.guestCount = guestCount;
        this.roomType = roomType;
        this.nights = nights;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
