package NordeaGroup.ProjectCountriesAPI;

import java.util.Arrays;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

public class Test {
	private static String url_populations ="https://countriesnow.space/api/v0.1/countries/population/";
	private static RestTemplate restTemplate = new RestTemplate();

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

	public static void main(String[] args) throws JSONException {
		System.out.println(new Test().getPopulation("Finland"));
	}

}
