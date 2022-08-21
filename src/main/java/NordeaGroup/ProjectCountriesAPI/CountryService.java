package NordeaGroup.ProjectCountriesAPI;

import java.util.Arrays;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryService {
    private final WebClient webClient;
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static String url_countries ="https://countriesnow.space/api/v0.1/countries";
    private static String url_capitols = "https://countriesnow.space/api/v0.1/countries/capital";
    private static String url_codes = "https://countriesnow.space/api/v0.1/countries/codes";
	private static String url_populations ="https://countriesnow.space/api/v0.1/countries/population";
	private static String url_flags = "https://countriesnow.space/api/v0.1/countries/flag/images";

    public CountryService(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://countriesnow.space/api/v0.1/countries").build();
	}
       
    public Mono<Response> getCountriesMono() {
           return webClient
            .get()
            .uri("/iso")
            .retrieve()
            .bodyToMono(Response.class);    
    }
    
    public Flux<Response> getCountriesFlux() {
        return webClient
         .get()
         .uri("/iso")
         .retrieve()
         .bodyToFlux(Response.class);    
    }
    
	public String getCapital(String name) throws JSONException {
		String response = restTemplate.getForObject(url_capitols, String.class);
		JSONObject jsonObject = new JSONObject(Arrays.asList(response).get(0));
		
		JSONArray data = jsonObject.getJSONArray("data");
		for (int i = 0 ; i < data.length(); i++) {
	        JSONObject obj = data.getJSONObject(i);
	        if (name.equalsIgnoreCase(obj.getString("name"))){	        	
	        	return obj.getString("capital");
	        }
	    }
		return null;
	}
	
	public String getCode(String name) throws JSONException {
		String response = restTemplate.getForObject(url_codes, String.class);
		JSONObject jsonObject = new JSONObject(Arrays.asList(response).get(0));
		
		JSONArray data = jsonObject.getJSONArray("data");
		for (int i = 0 ; i < data.length(); i++) {
	        JSONObject obj = data.getJSONObject(i);
	        if (name.equalsIgnoreCase(obj.getString("name"))){	        	
	        	return obj.getString("code");
	        }
	    }
		return null;
	}

	public String getFlag_file_url(String name) throws JSONException {
		String response = restTemplate.getForObject(url_flags, String.class);
		JSONObject jsonObject = new JSONObject(Arrays.asList(response).get(0));
		
		JSONArray data = jsonObject.getJSONArray("data");
		for (int i = 0 ; i < data.length(); i++) {
	        JSONObject obj = data.getJSONObject(i);
	        if (name.equalsIgnoreCase(obj.getString("name"))){	        	
	        	return obj.getString("flag");
	        }
	    }
		return null;
	}
	
	public Double getPopulation(String name) throws JSONException {
		String response = restTemplate.getForObject(url_populations, String.class);
		JSONObject jsonObject = new JSONObject(Arrays.asList(response).get(0));
		JSONArray data = jsonObject.getJSONArray("data");
		
		for (int i = 0 ; i < data.length(); i++) {
	        JSONObject obj = data.getJSONObject(i);

	        if (name.equalsIgnoreCase(obj.getString("country"))) {
	        	JSONArray populations = obj.getJSONArray("populationCounts");
	        	
	        	JSONObject obj2 = obj.getJSONArray("populationCounts").getJSONObject(populations.length()-1);
	        	return Double.parseDouble(obj2.getString("value"));
	        }
	    }
		return null;
	}
	
	public JSONObject getCountryByName(String name) throws JSONException {
		String url = "https://countriesnow.space/api/v0.1/countries";
		String response = restTemplate.getForObject(url, String.class);
		JSONObject jsonObject = new JSONObject(Arrays.asList(response).get(0));
		
		JSONObject json = new JSONObject() 
    	{{
      	  put("error", name+" not found");
      	  put("msg", "Check country name");
    	}};
				
		JSONArray data = jsonObject.getJSONArray("data");
		for (int i = 0 ; i < data.length(); i++) 
		{
	        JSONObject obj = data.getJSONObject(i);
	        if (name.equalsIgnoreCase(obj.getString("country")))//name
	        {
	        	json = new JSONObject() 
	        	{{
		        	  put("name", obj.getString("country"));//name
		        	  put("capital", getCapital(name));
		        	  put("country_code", getCode(name));
		        	  put("population", getPopulation(name));
		        	  put("flag_file_url", getFlag_file_url(name));
		        }};
		      return json;
	        }
	    }
		return json;
	}

}