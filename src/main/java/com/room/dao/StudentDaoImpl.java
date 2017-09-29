package com.room.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.room.model.Student;

@Repository
public class StudentDaoImpl  extends AbstractDao implements StudentDao {

	@Override
	public Student getStudent(int id) {
		return  (Student) getSession().get(Student.class, id);
	}

	@Override
	public void updateStudent(Student student) {
		getSession().update(student);
		
	}

	@Override
	public void deleteStudent(Student student) {
		getSession().delete(student);
		
	}

	@Override
	public Serializable saveStudent(Student student) {
		return getSession().save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		Query<Student> query = getSession().createQuery(criteriaQuery);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> findAllRooms(int id) {
			//List<Student> result = (List<Student>) getSession().createQuery("FROM student s WHERE s.roomId = :roomId").list();
			//Query query = getSession().createQuery(hql);
		     String hql= "FROM Student S WHERE roomId = :roomId";
			Query query = getSession().createQuery(hql); 
			query.setParameter("roomId", id);
			List<Student> students=query.getResultList();
	     	return students;
	}

}
