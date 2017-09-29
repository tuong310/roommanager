package com.room.dao;

import java.io.Serializable;
import java.util.List;

import com.room.model.Contract;
public interface ContractDao {

	Contract getContract(int id);
	void updateContract(Contract contract);
	void deleteContract(Contract contract);
	Serializable saveContract(Contract contract);
	List<Contract> findAllContracts();
	List<Contract> findAllContracts(int id);
}
