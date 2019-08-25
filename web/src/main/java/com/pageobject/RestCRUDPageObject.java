package com.pageobject;

import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.constant.Constant;
import com.utility.utilityfunctions;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;


public class RestCRUDPageObject {
    protected WebDriver driver;
    static Logger log = Logger.getLogger(RestCRUDPageObject.class);
   
	
	public RestCRUDPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void ConnectToEmpAPI() {
		try
		{
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//connect to EndPoint 
		RestAssured.baseURI =	Constant.ALL_EMP_URI;

		//create request object
		RequestSpecification request = RestAssured.given();
		
		//create response object;
		Response response = request.get();
		
		//check response status
		System.out.println("Status code:"+response.getStatusCode());	
		System.out.println(response.getBody().asString());
		
		}
		
		catch(Exception e)
		{
			Assert.fail("unable to get all emp details");
		}
		
		
	}
	

	public void ConnectToSingleEmpAPI() {
		try
		{
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//connect to EndPoint 
		RestAssured.baseURI =	Constant.SINGLE_EMP_URI;
		
		//create request object
		RequestSpecification request = RestAssured.given();
		
		//create response object;
		Response response = request.get();
		
		//check response status
		System.out.println("Status code:"+response.getStatusCode());	
		System.out.println(response.getBody().asString());
		
		}
		
		catch(Exception e)
		{
			Assert.fail("unable to get single emp details");
		}
		
	}
	

	public void ConnectToEmpPostMethod() {
		
		try
		{
			
		//connect to the base url
		RestAssured.baseURI =	Constant.EMP_POST_URI;
		
		//create request object
		RequestSpecification request = RestAssured.given();
		
		//set content type to json
		request.header("Content-Type", "application/json;charset=utf-8");
		
		//generating unique name
		Date date = new Date();
		System.out.println("Current date using Date = "+date.toString());
		String finalname="khalid"+date.getTime();
		
		//creating new record as string
		String strJsonString = "{\"name\":$name,\"salary\":\"45000\",\"age\":\"27\"}" ;
		String FinalString=strJsonString.replace("$name", finalname);
		
		//converting  string into json
		JSONObject requestParams = new JSONObject(FinalString);
		
		//setting message body 
		request.body(requestParams.toString());
		
		//creating response object
		Response response = request.post();
		
		//validating the response
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		}
		
		catch(Exception e)
		{
			Assert.fail("unable to create new request");
		}
		
	}
	

	public void ConnectToEmpPutMethod() {
		
		try
		{
			
		//connect to the base url
		RestAssured.baseURI =	Constant.EMP_PUT_URI;
				
		//create request object
		RequestSpecification request = RestAssured.given();
				
		//set content type to json
		request.header("Content-Type", "application/json;charset=utf-8");
				
		//generating unique name
		Date date = new Date();
		System.out.println("Current date using Date = "+date.toString());
		String finalname="updatedempname"+date.getTime();
				
		//creating new record as string
		String strJsonString = "{\"name\":$name,\"salary\":\"45000\",\"age\":\"27\"}" ;
		String FinalString=strJsonString.replace("$name", finalname);
				
		//converting  string into json
		JSONObject requestParams = new JSONObject(FinalString);
				
		//setting message body 
		request.body(requestParams.toString());
				
		//creating response object
		Response response = request.put();
				
		//validating the response
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
	    }
		
		catch(Exception e)
		{
			Assert.fail("No record found");
		}
		
	}
	

	public void ConnectToEmpDeleteMethod(String emp) {
		
		try
		{
			
		//connect to the base url
		RestAssured.baseURI =	Constant.EMP_DELETE_URI+emp;
						
		//create request object
		RequestSpecification request = RestAssured.given();
						
		//set content type to json
		request.header("Content-Type", "application/json;charset=utf-8");
						
		//creating response object
		Response response = request.delete();
						
		//validating the response
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		}
		
		catch(Exception e)
		{
			Assert.fail("No record found");
		}
		
		
		
	}


	public void performGetForInvalidEmp() {
		try
		{
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//connect to EndPoint 
		RestAssured.baseURI =	Constant.ALL_EMP_URI_INVALID;
			
		//create request object
		RequestSpecification request = RestAssured.given();
			
		//create response object;
		Response response = request.get();
			
		//check response status
		System.out.println("Status code:"+response.getStatusCode());	
		System.out.println(response.getBody().asString());
			
		//validate reponse for invalid data
		Assert.assertEquals(200,response.getStatusCode());
			
		if(response.getBody().asString().contains("false"))
		{
			
		System.out.println("Employee is invalid");
		
		}
		else
		{
		Assert.fail();
		}
		
		}
		
		catch(Exception e)
		{
			Assert.fail("unable to get  emp details");
		}
		
		
	}


	public void performPostForInvalidEmp() {

		try
		{
			
		//connect to the base url
		RestAssured.baseURI =	Constant.EMP_POST_URI_INVALID;
		
		//create request object
		RequestSpecification request = RestAssured.given();
		
		//set content type to json
		request.header("Content-Type", "application/json;charset=utf-8");
		
		//generating unique name
		Date date = new Date();
		System.out.println("Current date using Date = "+date.toString());
		//String finalname="khalid"+date.getTime();
		
		//creating new record as string
		String strJsonString = "{\"name\":$name,\"salary\":\"45000\",\"age\":\"27\"}" ;
		String FinalString=strJsonString.replace("$name", "pradeep");
		
		//converting  string into json
		JSONObject requestParams = new JSONObject(FinalString);
		
		//setting message body 
		request.body(requestParams.toString());
		
		//creating response object
		Response response = request.post();
		
		//validating the response
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		Assert.assertEquals(200,response.getStatusCode());
		
		}
		
		catch(Exception e)
		{
			Assert.fail("unable to create new request");
		}
		
	}


	public void performPutForInvalidEmp() {
		try
		{
			
		//connect to the base url
		RestAssured.baseURI =	Constant.EMP_PUT_URI_INVALID;
				
		//create request object
		RequestSpecification request = RestAssured.given();
				
		//set content type to json
		request.header("Content-Type", "application/json;charset=utf-8");
				
		//generating unique name
		Date date = new Date();
		System.out.println("Current date using Date = "+date.toString());
		String finalname="updatedempname"+date.getTime();
				
		//creating new record as string
		String strJsonString = "{\"name\":$name,\"salary\":\"0\",\"age\":\"34\"}" ;
		String FinalString=strJsonString.replace("$name",finalname);
				
		//converting  string into json
		JSONObject requestParams = new JSONObject(FinalString);
				
		//setting message body 
		request.body(requestParams.toString());
				
		//creating response object
		Response response = request.put();
				
		//validating the response
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(response.getStatusCode(),404);
		soft.assertAll();

		
	    }
		
		catch(Exception e)
		{
			Assert.fail("No record found");
		}
		
	}


	public void performDeleteForInvalidEmp() {
		try
		{
			
		//connect to the base url
		RestAssured.baseURI =	Constant.EMP_DELETE_URI_INVALID;
						
		//create request object
		RequestSpecification request = RestAssured.given();
						
		//set content type to json
		request.header("Content-Type", "application/json;charset=utf-8");
						
		//creating response object
		Response response = request.delete();
						
		//validating the response
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(response.getStatusCode(),404);
		soft.assertAll();
		
		}
		
		catch(Exception e)
		{
			Assert.fail("No record found");
		}
		
	}

	
}
