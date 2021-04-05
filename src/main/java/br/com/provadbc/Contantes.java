package br.com.provadbc;

import io.restassured.http.ContentType;

public interface Contantes {

	String APP_BASE_URL = "http://localhost:8080/api/v1";
	Integer APP_PORT = 8080; // http -> 80
	String APP_BASE_PATH = "";

	ContentType APP_CONTENT_TYPE = ContentType.JSON;

	Long MAX_TIMEOUT = 5000L;
}
