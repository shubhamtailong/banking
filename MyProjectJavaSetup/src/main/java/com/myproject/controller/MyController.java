package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Accounts;
import com.myproject.model.Customer;
import com.myproject.model.Operations;
import com.myproject.repository.AccountsRepo;
import com.myproject.repository.CustomerRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyController {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private AccountsRepo accountRepo;

	@PostMapping("/createAccount")
	public String createCustomer(@RequestBody Customer customer) throws Exception {
		System.out.println(customer.toString());
		String result="";
		if(null==customer.getEmailId()|| customer.getEmailId().isEmpty()|| null==customer.getFirstName()||customer.getFirstName().isEmpty()|| null==customer.getLastName()||customer.getLastName().isEmpty() ||null==customer.getPanNumber()||customer.getPanNumber().isEmpty()||0==customer.getPhoneNumber()|| null==customer.getDob()||customer.getDob().isEmpty()|| null==customer.getPassword()||customer.getPassword().isEmpty()) {
			result="**Please Fill the Mandatory Fields. Mandatory Feilds are Email,First Name, Last Name, PAN,Phone Number,DOB,Password";
			return result;
		}
		
		
		Customer cust= customerRepo.findBypanNumber(customer.getPanNumber());
		
		if(cust!=null) {
			
		
			result="User Already Exists. Please login with your credentials";
			return result;
		}
	
		Customer customer1=customerRepo.save(customer);
		Accounts accounts= new Accounts();
		accounts.setBalance(0.00);
		accounts.setIFSC("CITI001");
		accounts.setCustomerId(customer1.getCustomerId());
		/* accounts.set */
		accountRepo.save(accounts);
		result="Account Created Successfully. You Customer ID is:-"+customer1.getCustomerId();
		return result; 
	}

	@GetMapping("/getBalance/{id}/{pwd}")	
	public String getBalance(@PathVariable("id") int id, @PathVariable("pwd") String pass) {
		//Accounts account=accountRepo.findById(id);
		String result="";
		Customer customer= customerRepo.findBycustomerId(id);
		if(customer==null) {
			return "This Customer doesn't exists";
		}
		if(customer.getPassword().matches(pass)) {
			Accounts accounts= accountRepo.findBycustomerId(id);
			System.out.println(accounts.toString());
			result="Your Current Balance is:- INR "+accounts.getBalance();

		}
		else 			
			result="Wrong User/Pass Combination";

		return result;
	}


	@PostMapping("/operations")
	public String deposit(@RequestBody Operations ops) {
		System.out.println(ops.toString());
		String result="";
		Customer customer = customerRepo.findBycustomerId(ops.getId());
		if(customer==null) {
			return "This Customer doesn't exists";
		}

		if(ops.getBalance()<0) {
			result= "Withdrawal/Deposit amount cannot be negative";
			return result;
		}
				if(customer.getPassword().matches(ops.getPassword())) {
			Accounts account =accountRepo.findBycustomerId(customer.getCustomerId());
			if(ops.getOpType().matches("deposit")) {
				account.setBalance(ops.getBalance()+account.getBalance());
			}
			if(ops.getOpType().matches("withdraw")) {
				
				if(account.getBalance()>= ops.getBalance())
					account.setBalance(account.getBalance()-ops.getBalance());

				else {
					result="Insufficient Funds !!";
					return result;
				}
			}
			accountRepo.save(account);

			result= "Your Balance is updated. Current Balance:- INR"+ account.getBalance();
		}
		else
			result="Please login with current credentials";
		
		return result;
	}


	


}





