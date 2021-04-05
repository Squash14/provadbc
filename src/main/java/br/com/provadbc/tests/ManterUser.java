package br.com.provadbc.tests;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import br.com.provadbc.BaseTest;
import io.restassured.response.Response;

public class ManterUser extends BaseTest{
	
    String cadastrarUser = "{\n" +
            "  \"nome\": \"marcilio\",\n" +
            "  \"cpf\": 25917080100,\n" +
            "  \"email\": \"marcilio@email.com\",\n" +
            "  \"valor\": 1300,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";
    
    String cadastrarUserAlter = "{\n" +
            "  \"nome\": \"Lidia dos Anjos\",\n" +
            "  \"cpf\": 22221301072,\n" +
            "  \"email\": \"lida@email.com\",\n" +
            "  \"valor\": 12300,\n" +
            "  \"parcelas\": 9,\n" +
            "  \"seguro\": true\n" +
            "}";
    
    String alterarUser = "{\n" +
            "  \"nome\": \"Maria Clara\",\n" +
            "  \"cpf\": 60885648064,\n" +
            "  \"email\": \"maria@email.com\",\n" +
            "  \"valor\": 15000,\n" +
            "  \"parcelas\": 2,\n" +
            "  \"seguro\": true\n" +
            "}";
	
	@Test
	public void postUser(){
		
		Response response = given()
				.body(cadastrarUser)
		.when()
			.post("/simulacoes/")
		.then()
			.log().all()
			.statusCode(201)
			.contentType("application/json")
			.extract()
			.response()
		;
		String userId = response.jsonPath().getString("id");
		System.out.println(userId);
	
	deleteUser(userId);
	}
	
	@Test
	public void putUser(){
		
		Response response = given()
				.body(cadastrarUserAlter)
		.when()
			.post("/simulacoes/")
		.then()
			.log().all()
			.statusCode(201)
			.contentType("application/json")
			.extract()
			.response()
		;
		String userId = response.jsonPath().getString("id");
		String cpfUser = response.jsonPath().getString("cpf");
		System.out.println(userId);
		System.out.println(cpfUser);
		
		given()
				.body(alterarUser)
		.when()
			.put("/simulacoes/" + cpfUser + "/")
		.then()
			.log().all()
			.statusCode(200)
			.contentType("application/json")
			.extract()
			.response()
		;
	
	deleteUser(userId);
	}
	
	

	public void deleteUser(String userId) {
		
		given()
		.log().all()
		.when()
			.delete("/simulacoes/" + userId)
		.then()
			.log().all()
			.statusCode(200)
			;
	}

}
