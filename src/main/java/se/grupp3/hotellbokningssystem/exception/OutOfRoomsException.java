package se.grupp3.hotellbokningssystem.exception;

import se.grupp3.hotellbokningssystem.model.RoomType;

public class OutOfRoomsException extends Exception {
    public OutOfRoomsException(RoomType roomType){
        super("No more rooms of type " + roomType);
    }
}
