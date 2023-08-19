package com.test.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	PrintStream log;
	static Properties prop;
	static String dir = System.getProperty("user.dir");

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			log = new PrintStream(new FileOutputStream("logging.txt"));

			req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl")).setContentType("application/json")
					.addHeaders(Testdatabuild.setHeaders()).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

			return req;
		}
		return req;
	}

	public static String getGlobalValues(String key) throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(dir + "\\src\\test\\resources\\global.properties");
		prop.load(file);
		return prop.getProperty(key);
	}

	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.getString(key).toString();
	}
}