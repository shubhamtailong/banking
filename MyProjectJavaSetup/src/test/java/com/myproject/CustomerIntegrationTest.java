package com.myproject;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.model.Customer;
import com.myproject.model.Operations;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectJavaSetupApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
    private int port;
	
	 private String getRootUrl() {
         return "http://localhost:" + port;
     }
	 
	 @Test
     public void contextLoads() {

     }
	
	 @Test
     public void testCreateAccount() {
		 Customer customer = new Customer();
		 customer.setEmailId("shubham_tailong@live.com");
		 customer.setCity("Mathura");
		 customer.setDob("24/11/1994");
		 customer.setFirstName("Shubham");
		 customer.setLastName("Tailong");
		 customer.setPanNumber("AQMF6675");
		 customer.setPassword("abcd");
		 customer.setPhoneNumber(841003081);
		 	
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/createAccount", customer, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
    }
	 @Test
     public void testCreateAccountWithoumandatoryVal() {
		 Customer customer = new Customer();
		 customer.setEmailId("");
		 customer.setCity("Mathura");
		 customer.setDob("24/11/1994");
		 customer.setFirstName("Shubham");
		 customer.setLastName("Tailong");
		 customer.setPanNumber("");
		 customer.setPassword("abcd");
		 customer.setPhoneNumber(841003081);
		 	
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/createAccount", customer, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
    }
	 
	 @Test
	 public void testGetBalance() {
		 String balance = restTemplate.getForObject(getRootUrl() + "/getBalance/1/abcd", String.class);
		 System.out.println(balance);
		 assertNotNull(balance);
	 }

	 @Test
	 public void testoperationsDeposit() {
		 Operations op= new Operations();
		 op.setBalance(10.00);
		 op.setId(1);
		 op.setPassword("abcd");
		 op.setOpType("deposit");
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/operations", op, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
		 
		 
	 }
	 
	 @Test
	 public void testoperationsWithdraw() {
		 Operations op= new Operations();
		 op.setBalance(10.00);
		 op.setId(1);
		 op.setPassword("abcd");
		 op.setOpType("withdraw");
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/operations", op, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
		 
		 
	 }
	 
	 @Test
	 public void testoperationsNegativeValue() {
		 Operations op= new Operations();
		 op.setBalance(-10.00);
		 op.setId(1);
		 op.setPassword("abcd");
		 op.setOpType("withdraw");
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/operations", op, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
		 
		 
	 }
	 
	 @Test
	 public void testoperationsWrongUserId() {
		 Operations op= new Operations();
		 op.setBalance(-10.00);
		 op.setId(6);
		 op.setPassword("abcd");
		 op.setOpType("withdraw");
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/operations", op, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
		 
		 
	 }
	 
	 @Test
	 public void testoperationsInsufficientBal() {
		 Operations op= new Operations();
		 op.setBalance(1000.00);
		 op.setId(1);
		 op.setPassword("abcd");
		 op.setOpType("withdraw");
		 ResponseEntity<String> postResponse= restTemplate.postForEntity(getRootUrl() + "/operations", op, String.class);
		 System.out.println(postResponse);
		 assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
     
		 
		 
	 }
	 
	 
}
