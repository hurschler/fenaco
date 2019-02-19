
package com.fenaco.ua.ibm.imagereco.model;

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
@JsonPropertyOrder({ "name", "classifier_id", "classes" })
public class Classifier {

    @JsonProperty("name")
    private String name;
    @JsonProperty("classifier_id")
    private String classifierId;
    @JsonProperty("classes")
    private List<Class> classes = null;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("classifier_id")
    public String getClassifierId() {
        return classifierId;
    }

    @JsonProperty("classifier_id")
    public void setClassifierId(String classifierId) {
        this.classifierId = classifierId;
    }

    @JsonProperty("classes")
    public List<Class> getClasses() {
        return classes;
    }

    @JsonProperty("classes")
    public void setClasses(List<Class> classes) {
        this.classes = classes;
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
