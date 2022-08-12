package com.gadget.WeatherTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;

import com.gadget.Weather.WeatherService;

class WeatherServiceTests {
	@Test
	public void requestBuilderTest() throws URISyntaxException {
		WeatherService tester = new WeatherService();
		System.out.println(tester.requestBuilder("77068"));
	}
	@Test
	public void getWeatherDataTest() throws URISyntaxException, ClientProtocolException, IOException {
		WeatherService tester = new WeatherService();
		URIBuilder testBuilder = tester.requestBuilder("77068");
		tester.getWeatherData(testBuilder);
	}
	//need two versions of this one where the location is a bad value and method returns null
	@Test
	public void parseJSONWeatherDataNullTest() {}
	//happy path of the test above 
	@Test
	public void parseJSONWeatherDataTest() throws URISyntaxException, ClientProtocolException, IOException {
		WeatherService tester = new WeatherService();
		URIBuilder testBuilder = tester.requestBuilder("77068");
		JSONObject testData = tester.getWeatherData(testBuilder);
		tester.parseJSONWeatherDataAndCreateWeatherObject(testData);
		assertNotNull(testData.getJSONArray("days"));
	}
}