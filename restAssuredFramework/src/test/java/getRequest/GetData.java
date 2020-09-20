package getRequest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetData {

	@Test
	public void testResponseCode() {

		int code = get("http://api.citybik.es/v2/networks").statusCode();
		System.out.println("The status code is : " + code);

		assertEquals(code, 200);
	}

	@Test
	public void getLocation() {

		String loc = get("http://api.citybik.es/v2/networks?fields=location").asString();
		System.out.println("Bike locations Across the world" + loc);

	}

	@Test
	public void responseTime() {

		long time = get("http://api.citybik.es/v2/networks").getTime();
		System.out.println("Response time is " + time);

		assertTrue(time < 1000);
	}

}
