package com.room.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.room.model.Room;

@Repository
public class RoomDaoImpl extends AbstractDao implements RoomDao {

	@Override
	public Room getRoom(int id) {
		return (Room) getSession().get(Room.class, id);
	}

	@Override
	public void deleteRoom(Room room) {
		getSession().delete(room);
		
	}

	@Override
	public Serializable saveRoom(Room room) {
		return getSession().save(room);
	}

	@Override
	public void updateRoom(Room room) {
		getSession().update(room);
		
	}

	@Override
	public List<Room> findAllRooms() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = criteriaQuery.from(Room.class);
		criteriaQuery.select(root);
		Query<Room> query = getSession().createQuery(criteriaQuery);
		List<Room> rooms = query.getResultList();	
		return rooms;
	}


}
