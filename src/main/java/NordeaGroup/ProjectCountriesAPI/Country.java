
package NordeaGroup.ProjectCountriesAPI;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "iso2",
    "country",
})
@Generated("jsonschema2pojo")
public class Country {

    private String country_code;
    private String name;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("country_code")
    public String getIso2() {
        return country_code;
    }

    @JsonProperty("Iso2")
    public void setIso2(String iso2) {
        this.country_code = iso2;
    }
}
