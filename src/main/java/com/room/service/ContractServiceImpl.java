package com.room.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.room.dao.ContractDao;
import com.room.dao.StudentDao;
import com.room.dto.ContractManufacture;
import com.room.model.Contract;
import com.room.model.Student;

@Service("contractService")
@Transactional
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractDao contractDao;
	
	@Autowired
	StudentDao studentDao;
	public Contract convert(ContractManufacture contractManufacture){
		Contract contract = new Contract();
		contract.setId(contractManufacture.getId());
		contract.setName(contractManufacture.getName());
		return contract;
	}
	public ContractManufacture convert(Contract contract){
		ContractManufacture contractManufacture = new ContractManufacture();
		if(contract.getStudent() != null){
			contractManufacture.setStudentId(contract.getStudent().getId());
		}
		contractManufacture.setId(contract.getId());
		contractManufacture.setName(contract.getName());
		return contractManufacture;
	}
	@Override
	public ContractManufacture getContract(int id) {
		Contract contract = contractDao.getContract(id);
		ContractManufacture contractManufacture = convert(contract);
		return contractManufacture;
	}

	@Override
	public void updateContract(ContractManufacture contractManufacture) {
		Student student = studentDao.getStudent(contractManufacture.getStudentId());
		Contract contract = convert(contractManufacture);
		contract.setStudent(student);
		contractDao.updateContract(contract);
		
	}

	@Override
	public void deleteContract(ContractManufacture contractManufacture) {
		Student student = studentDao.getStudent(contractManufacture.getStudentId());
		Contract contract = convert(contractManufacture);
		contract.setStudent(student);
		contractDao.deleteContract(contract);
		
	}

	@Override
	public Serializable saveContract(ContractManufacture contractManufacture) {
		Student student = studentDao.getStudent(contractManufacture.getStudentId());
		Contract contract = convert(contractManufacture);
		contract.setStudent(student);
		return contractDao.saveContract(contract);
	}

	@Override
	public List<ContractManufacture> findAllContracts() {
		List<ContractManufacture> contractManufactures = new ArrayList<ContractManufacture>();
		List<Contract> contracts = contractDao.findAllContracts();
		if(!CollectionUtils.isEmpty(contracts)){
			for(Contract contract : contracts){
				contractManufactures.add(convert(contract));
			}
		}
		return contractManufactures;
	}
	@Override
	public List<ContractManufacture> findAllContracts(int id) {
		List<ContractManufacture> contractManufactures = new ArrayList<ContractManufacture>();
		List<Contract> contracts = contractDao.findAllContracts(id);
		if(!CollectionUtils.isEmpty(contracts)){
			for(Contract contract : contracts){
				contractManufactures.add(convert(contract));
			}
		}
		return contractManufactures;
	}

}
