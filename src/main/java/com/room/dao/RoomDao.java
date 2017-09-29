package com.room.dao;

import java.io.Serializable;
import java.util.List;


import com.room.model.Room;

public interface RoomDao {

	Room getRoom(int id);
    void deleteRoom(Room room);
    Serializable saveRoom(Room room);
    void updateRoom(Room room);
    List<Room> findAllRooms();
  
}
