
package com.fenaco.ua.ibm.imagereco.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "class", "score", "type_hierarchy" })
public class Class {

    @JsonProperty("class")
    private String _class;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("type_hierarchy")
    private String typeHierarchy;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonProperty("type_hierarchy")
    public String getTypeHierarchy() {
        return typeHierarchy;
    }

    @JsonProperty("type_hierarchy")
    public void setTypeHierarchy(String typeHierarchy) {
        this.typeHierarchy = typeHierarchy;
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
