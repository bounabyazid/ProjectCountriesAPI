package NordeaGroup.ProjectCountriesAPI;

import static org.hamcrest.Matchers.equalTo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
public class TestController {

	@Autowired
	private CountryController controller;
	
	@Autowired
	private CountryService service;

    @Autowired
	private MockMvc mvc;
    
    @Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
    
    
    @Test
	public void getCountryByName() throws Exception {
    	String target = "{\"name\":\"Finland\",\"capital\":\"Helsinki\",\"country_code\":\"FI\",\"population\":5515525,\"flag_file_url\":\"https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/b\\/bc\\/Flag_of_Finland.svg\"}";

    	mvc.perform(MockMvcRequestBuilders.get("/Finland").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(target)));
    	}			
    
    @Test
	public void getCountries() throws Exception {
    	ResultActions response = mvc.perform(MockMvcRequestBuilders.get("/countries").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(content().string(equalTo(response)));
		
	}
}
