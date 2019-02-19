
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
@JsonPropertyOrder({ "custom_classes", "images_processed", "images" })
public class ImageResult {

    @JsonProperty("custom_classes")
    private Integer customClasses;
    @JsonProperty("images_processed")
    private Integer imagesProcessed;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("custom_classes")
    public Integer getCustomClasses() {
        return customClasses;
    }

    @JsonProperty("custom_classes")
    public void setCustomClasses(Integer customClasses) {
        this.customClasses = customClasses;
    }

    @JsonProperty("images_processed")
    public Integer getImagesProcessed() {
        return imagesProcessed;
    }

    @JsonProperty("images_processed")
    public void setImagesProcessed(Integer imagesProcessed) {
        this.imagesProcessed = imagesProcessed;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
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
