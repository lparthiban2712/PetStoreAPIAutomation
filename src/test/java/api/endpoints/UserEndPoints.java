package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payloads.UserPayloads;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static ResourceBundle  getendpoints()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response createuser(UserPayloads payload)
	{
		String post_url= UserEndPoints.getendpoints().getString("post_url");
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when().post(post_url);
		return response;
	}
	
	
	public static Response getuser(String username)
	{
		String get_url= UserEndPoints.getendpoints().getString("get_url");
		Response response=given().pathParam("username", username).get(get_url);
		return response;
	}
	
	public static Response updateuser(UserPayloads payload, String username)
	{
		String update_url= UserEndPoints.getendpoints().getString("update_url");
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", username).body(payload).when().put(update_url);
		return response;
	}
	
	public static Response deleteuser(String username)
	{
		String delete_url= UserEndPoints.getendpoints().getString("delete_url");
		Response response=given().pathParam("username", username).get(delete_url);
		return response;
	}

}
