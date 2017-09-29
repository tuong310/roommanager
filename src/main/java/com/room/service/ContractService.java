package com.room.service;

import java.io.Serializable;
import java.util.List;

import com.room.dto.ContractManufacture;

public interface ContractService {

	ContractManufacture getContract(int id);
	void updateContract(ContractManufacture contract);
	void deleteContract(ContractManufacture contract);
	Serializable saveContract(ContractManufacture contract);
	List<ContractManufacture> findAllContracts();
	List<ContractManufacture> findAllContracts(int id);
}
