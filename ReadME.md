#Project Description
- This API project developed to test REST API services for - booker.herokuapp.com

##Project Contains-
	1.com.test.utilities - Testdatabuild.java: to build payload using POJO and Utils.java:	reasuable utilities
	2.cucumber.Option - TestRunner file
	3.feature - This file contains feature that will be tested 
	4.stepDefination - Actual implementation of feature using java
	5.com.test.constants - Contains endpoints with methods supported
	6.pojo- for serialization of given payload in to json


#Technologies used
- Java
- Maven
- Cucumber
- Git
- Rest API

#How to execute
1. Import/Clone the project to local repo/eclipse.
2. create a new Maven goal as - clean test -Dcucumber.options="--tags @UpdateBooking"
3. Execute by clicking on Run button

Note : 
- -Dcucumber.options="--tags @UpdateBooking" this is cucumber Maven argument to select and run a particular test
- Report is stored in folder Herokuapp\target\cucumber-html-reports with file name - overview-features
- Request and Response logs are stored in- Herokuapp/logging.txt file
