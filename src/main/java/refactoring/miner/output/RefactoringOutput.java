package refactoring.miner.output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "description",
        "leftSideLocations",
        "rightSideLocations"
})
public class RefactoringOutput {

    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("leftSideLocations")
    private List<LeftSideLocation> leftSideLocations = null;
    @JsonProperty("rightSideLocations")
    private List<RightSideLocation> rightSideLocations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("leftSideLocations")
    public List<LeftSideLocation> getLeftSideLocations() {
        return leftSideLocations;
    }

    @JsonProperty("leftSideLocations")
    public void setLeftSideLocations(List<LeftSideLocation> leftSideLocations) {
        this.leftSideLocations = leftSideLocations;
    }

    @JsonProperty("rightSideLocations")
    public List<RightSideLocation> getRightSideLocations() {
        return rightSideLocations;
    }

    @JsonProperty("rightSideLocations")
    public void setRightSideLocations(List<RightSideLocation> rightSideLocations) {
        this.rightSideLocations = rightSideLocations;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}