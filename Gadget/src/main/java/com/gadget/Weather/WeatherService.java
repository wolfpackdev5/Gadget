package com.gadget.Weather;

import java.io.IOException;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.azure.core.http.HttpClient;

/*
 * this call is going to supply the helper methods that create the weather API request and submit the request
 */
public class WeatherService {
	private String apiEndPoint="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
	private String unitGroup="us"; //US, metric, UK 
	private String apiKey="4WEZA78GC22TAHDZ6W3QFW4K4";
	//constructor
	public WeatherService() {}
	/**
	 * create the request to Visual Crossing Weather API
	 * @throws URISyntaxException 
	 */
	public URIBuilder requestBuilder(String location) throws URISyntaxException {
		StringBuilder string = new StringBuilder(apiEndPoint);
		string.append(location).append("?");
		URIBuilder builder = new URIBuilder(string.toString());
		builder
		.setParameter("unitGroup", this.unitGroup)
		//key to access Visual Crossing account appended to request URI
		.setParameter("key", this.apiKey)
		.setParameter("contentType", "json");
		return builder;
	} 
	/**
	 * this method is going to get the JSON weather data from Visual Crossings using the requestBuilder 
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public JSONObject getWeatherData(URIBuilder builder) throws URISyntaxException, ClientProtocolException, IOException {
		//creating a get request to get weather data
		HttpGet get = new HttpGet(builder.build());
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(get);
		String raw = null;
		try {
			if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.printf("Bad response status code: %d%n", response.getStatusLine().getStatusCode());
				return null;
			}
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				raw = EntityUtils.toString(entity, Charset.forName("utf-8"));
			}
		} finally {
			response.close();
		}
		JSONObject jsonWeatherData = new JSONObject(raw);
		//System.out.println(jsonWeatherData);
		return jsonWeatherData;
	}
	/**
	 * method to use the JSON object created in getWeatherData method and take out the values we need from it
	 */
	public void parseJSONWeatherDataAndCreateWeatherObject(JSONObject jsonWeatherData) {
		ZoneId zoneId = ZoneId.of(jsonWeatherData.getString("timezone"));
		System.out.printf("Weather data for: %s%n", jsonWeatherData.getString("resolvedAddress"));		
		JSONArray values = jsonWeatherData.getJSONArray("days");
		System.out.printf("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
		for (int i = 0; i < values.length(); i++) {
		    JSONObject dayValue = values.getJSONObject(i);
		    ZonedDateTime datetime =
		        ZonedDateTime.ofInstant(Instant.ofEpochSecond(
		            dayValue.getLong("datetimeEpoch")), zoneId);
		    double maxtemp=dayValue.getDouble("tempmax");
		    double mintemp=dayValue.getDouble("tempmin");
		    double pop=dayValue.getDouble("precip");
		    String source=dayValue.getString("source");
		    System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%s%n",         
		        datetime.format(DateTimeFormatter.ISO_LOCAL_DATE),
		            maxtemp, mintemp, pop,source );
		    
		}
	}
}



/*JSONArray values=timelineResponse.getJSONArray("days");
		
System.out.printf("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
for (int i = 0; i < values.length(); i++) {
    JSONObject dayValue = values.getJSONObject(i);

    ZonedDateTime datetime=
        ZonedDateTime.ofInstant(Instant.ofEpochSecond(
            dayValue.getLong("datetimeEpoch")), zoneId);
            
    double maxtemp=dayValue.getDouble("tempmax");
    double mintemp=dayValue.getDouble("tempmin");
    double pop=dayValue.getDouble("precip");
    String source=dayValue.getString("source");
    System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%s%n",         
        datetime.format(DateTimeFormatter.ISO_LOCAL_DATE),
            maxtemp, mintemp, pop,source );
}*/
	
	
	
	
			
	
	