package RestTest;

import static io.restassured.RestAssured.given;

import org.junit.Test;


public class RestTestDBC {
	
	@Test
	public void colsutarCPF(){
		
		given()
			.log().all()
		.when()
			.get("http://localhost:8080/api/v1/simulacoes")
		.then()
		.statusCode(200)
		;
	}

}
