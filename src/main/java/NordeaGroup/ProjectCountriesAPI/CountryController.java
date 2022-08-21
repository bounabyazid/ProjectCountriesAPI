package NordeaGroup.ProjectCountriesAPI;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class CountryController {

	@Autowired
    private CountryService countryService;
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
//	@GetMapping("/countriesMono")
//	private Mono<Response> getAllCountriesMono() {
//	    return countryService.getCountriesMono();
//	}
	
	@GetMapping("/countries")
	private Flux<Response> getAllCountriesFlux() {
	    return countryService.getCountriesFlux();
	}
	
	@GetMapping(value = "/{name}", produces = { MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<?> getCountryByName(@PathVariable String name) throws JSONException  {
		    return new ResponseEntity<>(countryService.getCountryByName(name).toString(), HttpStatus.OK);
	}
}