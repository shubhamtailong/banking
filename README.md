READ ME

We are creating ATM/Simple Banking operations application. Where user can Create account for himself, make the transactions such as withdraw and deposit and check balance.

Setup Your Environment
1. GitHub Link:- git clone URl
2. Install Spring boot on your device. By using IDE Market Place or download the project from Spring.io.
3.  Dependencies :- H2 Database and JPA.

How to run Code ?
1. Go to IDE.
2. Right Click on project and run as Spring Boot Application

Connecting H2 DB
1. Username and Password are stored in Application.properties file.
2. Go to localhost:portNumber/h2-console
3. Login with credentials defined in application.properties

APIs Description
1.	createAcount
a.	API URL:- http://localhost:8080/createAccount
b.	Type: POST
c.	Body –
{
    "firstName": <String>,
    "lastName": <String>,
    "emailId": <String>,
    "phoneNumber": <int>,
    "panNumber": <String>,
    "dob": <String>,
    "city": <String>,
    "password": <String>
}
d.	Output/Response: -Account Created Successfully. You Customer ID is:-<CustomerID>

2.	getBalance/<customerId>/<Password>
a.	API  URL:- http://localhost:8080/getBalance/<customer>/<pass>
b.	TYPE:-  GET
c.	Output/Respnse:- “Your Current Balance is:-”<Balance>

3.	Operations
a.	API URL:- http://localhost:8080/operations
b.	TYPE:- POST
c.	Body:- 
{
    "id": <int>,
    "password": <String>,
    "balance": <Double>,
    "opType": <String>
}

d.	Output/Response: - “Your Balance is updated. Current Balance:-”<Balance>


