package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.UserPayloads;
import api.utilities.DataProvidersClass;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDT {
	
	@Test(priority=0,dataProvider="allusertestdata",dataProviderClass=DataProvidersClass.class)
	public void createuserusingDDT(String id, String username, String firstName, String lastName,String email,String password, String phone)
	{
		UserPayloads payload=new UserPayloads();
		payload.setId(Integer.parseInt(id));
		payload.setUsername(username);
		payload.setFirstName(firstName);
		payload.setLastName(lastName);
		payload.setEmail(email);
		payload.setPassword(password);
		payload.setPhone(phone);
		
		Response response=UserEndPoints.createuser(payload);
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test(priority=1,dataProvider="allusernames",dataProviderClass=DataProvidersClass.class)
	public void createuserusingDDT(String username)
	{
		
		
		Response response=UserEndPoints.deleteuser(username);
		Assert.assertEquals(200, response.getStatusCode());
	}

}
