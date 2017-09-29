package com.room.service;

import java.io.Serializable;
import java.util.List;

import com.room.dto.RoomManufacture;

public interface RoomService {
	
	RoomManufacture getRoom(int id);
	void updateRoom(RoomManufacture room);
	void deleteRoom(RoomManufacture room);
	Serializable saveRoom(RoomManufacture room);
	List<RoomManufacture> findAllRooms();
}
