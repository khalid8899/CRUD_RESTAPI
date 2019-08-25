package com.stepdefn;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pageobject.RestCRUDPageObject;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class RestCrudStepdefinition
{
	private Logger log = Logger.getLogger(RestCrudStepdefinition.class.getName());
	protected WebDriver driver;
	private RestCRUDPageObject pageObject;

	@Before
	public void setDriver()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Components\\chromedriver_win32\\chromedriver.exe");
		// Initialize browser
		driver=new ChromeDriver();
		
	}
	
	
	@Given("^Connect to Emp_Rest_API$")
	public void Connect_to_Emp_Rest_API()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.ConnectToEmpAPI();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@Given("^Connect to Emp_Rest_API_ and get single employee details$")
	public void Connect_to_Emp_Rest_API_SingleEmp()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.ConnectToSingleEmpAPI();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@Given("^Connect to Emp_Rest_API_ Post$")
	public void Connect_to_Emp_Rest_API_Post()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.ConnectToEmpPostMethod();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@Given("^Connect to Emp_Rest_API_ Put$")
	public void Connect_to_Emp_Rest_API_Put()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.ConnectToEmpPutMethod();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@Given("^Connect to Emp_Rest_API_ Delete emp \"([^\"]*)\"$")
	public void ConnecttoEmp_Rest_API_Delete(String emp)
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.ConnectToEmpDeleteMethod(emp);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	@And("^Peform Get operation for invalid employee$")
	public void Peform_Get_operation_for_invalid_employee()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.performGetForInvalidEmp();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@And("^Peform Post operation for invalid employee$")
	public void Peform_Post_operation_for_invalid_employee()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.performPostForInvalidEmp();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	@And("^Peform Put operation for invalid employee$")
	public void Peform_Put_operation_for_invalid_employee()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.performPutForInvalidEmp();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@And("^Peform Delete operation for invalid employee$")
	public void Peform_Delete_operation_for_invalid_employee()
	{
		try
		{
			pageObject = new RestCRUDPageObject(driver);
			pageObject.performDeleteForInvalidEmp();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@After
	public void closebrowser()
	{
		driver.close();
		
	}
	
	
	



}







