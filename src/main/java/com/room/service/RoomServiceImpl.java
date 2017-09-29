package com.room.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.room.dao.RoomDao;
import com.room.dto.RoomManufacture;
import com.room.model.Room;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;
	private Room convert(RoomManufacture roomManufacture){
		Room room = new Room();
		room.setId(roomManufacture.getId());
		room.setName(roomManufacture.getName());
		room.setLessee(roomManufacture.getLessee());
		return room;
		
	}
	private RoomManufacture convert(Room room){
		RoomManufacture roomManufacture = new RoomManufacture();
		roomManufacture.setId(room.getId());
		roomManufacture.setName(room.getName());
		roomManufacture.setLessee(room.getLessee());
		return roomManufacture;
	}
	@Override
	public RoomManufacture getRoom(int id) {
		Room room = roomDao.getRoom(id);
		RoomManufacture roomManufacture = convert(room);
		return roomManufacture;
	}

	@Override
	public void updateRoom(RoomManufacture roomManufacture) {
		Room room = convert(roomManufacture);
		roomDao.updateRoom(room);
		
	}

	@Override
	public void deleteRoom(RoomManufacture roomManufacture) {
		Room room = convert(roomManufacture);
		roomDao.deleteRoom(room);
		
	}

	@Override
	public Serializable saveRoom(RoomManufacture roomManufacture) {
		Room room = convert(roomManufacture);
		return roomDao.saveRoom(room);
	}

	@Override
	public List<RoomManufacture> findAllRooms() {
		List<RoomManufacture> roomManufactures = new ArrayList<RoomManufacture>();
		List<Room> rooms = roomDao.findAllRooms();
		if(!CollectionUtils.isEmpty(rooms)){
			for(Room room : rooms){
				roomManufactures.add(convert(room));
			}
		}
		return roomManufactures;
	}

}
