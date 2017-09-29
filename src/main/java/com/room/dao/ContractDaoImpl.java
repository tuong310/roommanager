package com.room.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.room.model.Contract;
import com.room.model.Student;

@Repository
public class ContractDaoImpl  extends AbstractDao implements ContractDao{

	@Override
	public Contract getContract(int id) {
		return (Contract) getSession().get(Contract.class, id);
	}

	@Override
	public void updateContract(Contract contract) {
		getSession().update(contract);
		
	}

	@Override
	public void deleteContract(Contract contract) {
		getSession().delete(contract);
		
	}

	@Override
	public Serializable saveContract(Contract contract) {
		return getSession().save(contract);
	}

	@Override
	public List<Contract> findAllContracts() {
		CriteriaBuilder  criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Contract> criteriaQuery = criteriaBuilder.createQuery(Contract.class);
		Root<Contract> root = criteriaQuery.from(Contract.class);
		criteriaQuery.select(root);
		Query<Contract> query = getSession().createQuery(criteriaQuery);
		List<Contract> contracts = query.getResultList();
		return contracts;
	}

	@Override
	public List<Contract> findAllContracts(int id) {
		     String hql= "FROM Contract C WHERE studentId = :studentId";
			Query query = getSession().createQuery(hql); 
			query.setParameter("studentId", id);
			List<Contract> contracts=query.getResultList();
	     	return contracts;
	}

}
