package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Accounts;
import com.myproject.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findBycustomerId(int id);
	public Customer findBypanNumber(String pan);

}
