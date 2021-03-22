package refactoring.miner.output;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "filePath",
        "startLine",
        "endLine",
        "startColumn",
        "endColumn",
        "codeElementType",
        "description",
        "codeElement"
})
public class RightSideLocation {

    @JsonProperty("filePath")
    private String filePath;
    @JsonProperty("startLine")
    private Integer startLine;
    @JsonProperty("endLine")
    private Integer endLine;
    @JsonProperty("startColumn")
    private Integer startColumn;
    @JsonProperty("endColumn")
    private Integer endColumn;
    @JsonProperty("codeElementType")
    private String codeElementType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("codeElement")
    private String codeElement;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("filePath")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("filePath")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("startLine")
    public Integer getStartLine() {
        return startLine;
    }

    @JsonProperty("startLine")
    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }

    @JsonProperty("endLine")
    public Integer getEndLine() {
        return endLine;
    }

    @JsonProperty("endLine")
    public void setEndLine(Integer endLine) {
        this.endLine = endLine;
    }

    @JsonProperty("startColumn")
    public Integer getStartColumn() {
        return startColumn;
    }

    @JsonProperty("startColumn")
    public void setStartColumn(Integer startColumn) {
        this.startColumn = startColumn;
    }

    @JsonProperty("endColumn")
    public Integer getEndColumn() {
        return endColumn;
    }

    @JsonProperty("endColumn")
    public void setEndColumn(Integer endColumn) {
        this.endColumn = endColumn;
    }

    @JsonProperty("codeElementType")
    public String getCodeElementType() {
        return codeElementType;
    }

    @JsonProperty("codeElementType")
    public void setCodeElementType(String codeElementType) {
        this.codeElementType = codeElementType;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("codeElement")
    public String getCodeElement() {
        return codeElement;
    }

    @JsonProperty("codeElement")
    public void setCodeElement(String codeElement) {
        this.codeElement = codeElement;
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
