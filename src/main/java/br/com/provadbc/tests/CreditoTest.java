package br.com.provadbc.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.provadbc.BaseTest;


public class CreditoTest extends BaseTest{
	
	String cpfComRestricao = "97093236014";
	String cpfNaoCadastrado = "25917080100";
	String cpfSemRestrito = "66414919004";
	String cpfNaoEncontrado = "19572496093";  
	
	@Test
	public void consultaSimulacoesCPFs(){
		given()
		.when()
			.get("/simulacoes")
		.then()
		.log().all()
		.statusCode(200)
		;
	}
	
	@Test
	public void consultaCPFValido(){
		given()
		.when()
			.get("/simulacoes/" + cpfSemRestrito)
		.then()
		.log().all()
		.statusCode(200)
		;
	}
	
	@Test
	public void consultaCPFNaoCadastrado(){
		given()
		.when()
			.get("/simulacoes/" + cpfNaoCadastrado)
		.then()
		.log().all()
		.statusCode(404)
		.body("mensagem", is("CPF " + cpfNaoCadastrado + " não encontrado"))
		;
	}
	
	@Test
	public void consultarCPFComRestricao(){
		given()
		.when()
			.get("/restricoes/" + cpfComRestricao)
		.then()
		.log().all()
		.statusCode(200)
		.body("mensagem", is("O CPF " + cpfComRestricao + " tem problema"))
		;
	}
	
	@Test
	public void consultarCPFSemRestricao(){
		given()
		.when()
			.get("/restricoes/" + cpfSemRestrito)
		.then()
		.log().all()
		.statusCode(204)
		;
	}
	
}
