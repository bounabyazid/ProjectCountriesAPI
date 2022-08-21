package NordeaGroup.ProjectCountriesAPI;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "error",
    "msg",
    "data"
})

@Generated("jsonschema2pojo")
public class Response {
	
	private boolean error;
    private String msg;
    private List<Country> data;

    @JsonIgnore
    public Boolean getError() {
        return error;
    }

    @JsonIgnore
    public String getMsg() {
        return msg;
    }
    
    @JsonProperty("countries")
    public List<Country> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Country> data) {
        this.data = data;
    }
}
