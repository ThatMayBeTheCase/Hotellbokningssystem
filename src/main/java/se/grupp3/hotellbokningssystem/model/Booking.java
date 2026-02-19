package se.grupp3.hotellbokningssystem.model;

import java.time.LocalDate;

public class Booking {
    private Integer id;
    private final String userName;
    private String guestName;
    private Integer guestCount;
    private RoomType roomType;
    private Integer totalPrice;
    private BookingStatus status;
    private int roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(Integer id, String userName, String guestName, Integer guestCount, RoomType roomType, Integer totalPrice, BookingStatus status, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.userName = userName;
        this.guestName = guestName;
        this.guestCount = guestCount;
        this.roomType = roomType;
        this.totalPrice = totalPrice;
        this.status = status;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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

    public String getUserName() {
        return userName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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
