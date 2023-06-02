package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.UserPayloads;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserTestCases {
	
	Faker faker;
	UserPayloads userpayloads;
	
	org.apache.logging.log4j.Logger logger;
	
	@BeforeClass
	public void setupdata()
	{
		faker=new Faker();
		userpayloads=new UserPayloads();
		userpayloads.setId(faker.idNumber().hashCode());
		userpayloads.setUsername(faker.name().username());
		userpayloads.setFirstName(faker.name().firstName());
		userpayloads.setLastName(faker.name().lastName());
		userpayloads.setEmail(faker.internet().safeEmailAddress());
		userpayloads.setPassword(faker.internet().password());
		userpayloads.setPhone(faker.phoneNumber().cellPhone());
		//userpayloads.getUserStatus(faker.st);
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=0, enabled=true)
	public void testcreateuser()
	{
		logger.info("testcreateuser started");
		Response response=UserEndPoints.createuser(userpayloads);
		

		System.out.println("Status code is "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("testcreateuser finished");
	}
	
	@Test(priority=1, enabled=true)
	public void testgetuser()
	{
		logger.info("testgetuser started");
		Response response=UserEndPoints.getuser(this.userpayloads.getUsername());
		System.out.println("Status code is "+response.getStatusCode());
		response.then().log().all();    
		System.out.println((response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsondata.json"))));
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("testgetuser finished");
	}
	
	@Test(priority=2, enabled=true)
	public void testupdateuser()
	{
		logger.info("testupdateuser started");
		userpayloads.setEmail(faker.internet().safeEmailAddress());
		userpayloads.setPassword(faker.internet().password());
		userpayloads.setPhone(faker.phoneNumber().cellPhone());
		Response response=UserEndPoints.updateuser(userpayloads,this.userpayloads.getUsername());
		System.out.println("Status code is "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("testupdateuser finished");
	}
	
	@Test(priority=3, enabled=true)
	public void testdeleteuser()
	{
		logger.info("testdeleteuser started");
		Response response=UserEndPoints.deleteuser(this.userpayloads.getUsername());
		System.out.println("Status code is "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("testdeleteuser finished");
	}

}
