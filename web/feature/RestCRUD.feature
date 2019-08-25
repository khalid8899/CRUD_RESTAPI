@smokeTest
Feature: Ability To Perform CRUD Operation On RestAPI.
 	
 	#Positive test cases
 	@positiveTest
  @TC_001
  Scenario: validate the response and get all employee data
  Given Connect to Emp_Rest_API
  
 	@positiveTest
  @TC_002
  Scenario: validate the response and get single employee data
  Given Connect to Emp_Rest_API_ and get single employee details
  
 	@positiveTest
  @TC_003
  Scenario: validate the response for post method
  Given Connect to Emp_Rest_API_ Post
  
  @positiveTest
  @TC_004
  Scenario: validate the response for put method
  Given Connect to Emp_Rest_API_ Put
  
  @positiveTest
  @TC_005
  Scenario: validate the response for Delete method
  Given Connect to Emp_Rest_API_ Delete emp "69260"
  
  #Negative test cases
  @NegativeTest 
  @TC_N_001
  Scenario: validate response for incorrect employee data-Get operation
  And Peform Get operation for invalid employee
  
  @NegativeTest 
  @TC_N_002
  Scenario: validate response for incorrect employee data-Post operation
  And Peform Post operation for invalid employee
  
  @NegativeTest 
  @TC_N_003
  Scenario: validate response for incorrect employee data-Put operation
  And Peform Put operation for invalid employee
  
  @NegativeTest 
  @TC_N_004
  Scenario: validate response for incorrect employee data-Delete operation
  And Peform Delete operation for invalid employee
  
  
  