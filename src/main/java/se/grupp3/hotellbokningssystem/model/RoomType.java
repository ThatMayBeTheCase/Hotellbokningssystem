package se.grupp3.hotellbokningssystem.model;

public enum RoomType {
    SINGLE(1, 10, 1000),
    DOUBLE(2, 7, 1500),
    SUITE(3, 3, 2000);

    private final int maxGuests;
    private final int nrOfRooms;
    private final int pricePerNight;

    RoomType(int maxGuests, int nrOfRooms, int pricePerNight) {
        this.maxGuests = maxGuests;
        this.nrOfRooms = nrOfRooms;
        this.pricePerNight = pricePerNight;
    }

    public int getMaxGuests() {
        return  maxGuests;
    }

    public int getNrOfRooms() {
        return nrOfRooms;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }
}
