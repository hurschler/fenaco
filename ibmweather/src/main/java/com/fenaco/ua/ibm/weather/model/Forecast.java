
package com.fenaco.ua.ibm.weather.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "class", "expire_time_gmt", "fcst_valid", "fcst_valid_local", "num", "max_temp", "min_temp", "torcon", "stormcon", "blurb", "blurb_author",
        "lunar_phase_day", "dow", "lunar_phase", "lunar_phase_code", "sunrise", "sunset", "moonrise", "moonset", "qualifier_code", "qualifier", "narrative",
        "qpf", "snow_qpf", "snow_range", "snow_phrase", "snow_code", "night", "day" })
public class Forecast {

    @JsonProperty("class")
    private String _class;
    @JsonProperty("expire_time_gmt")
    private Integer expireTimeGmt;
    @JsonProperty("fcst_valid")
    private Integer fcstValid;
    @JsonProperty("fcst_valid_local")
    private String fcstValidLocal;
    @JsonProperty("num")
    private Integer num;
    @JsonProperty("max_temp")
    private Integer maxTemp;
    @JsonProperty("min_temp")
    private Integer minTemp;
    @JsonProperty("torcon")
    private Object torcon;
    @JsonProperty("stormcon")
    private Object stormcon;
    @JsonProperty("blurb")
    private Object blurb;
    @JsonProperty("blurb_author")
    private Object blurbAuthor;
    @JsonProperty("lunar_phase_day")
    private Integer lunarPhaseDay;
    @JsonProperty("dow")
    private String dow;
    @JsonProperty("lunar_phase")
    private String lunarPhase;
    @JsonProperty("lunar_phase_code")
    private String lunarPhaseCode;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("moonrise")
    private String moonrise;
    @JsonProperty("moonset")
    private String moonset;
    @JsonProperty("qualifier_code")
    private Object qualifierCode;
    @JsonProperty("qualifier")
    private Object qualifier;
    @JsonProperty("narrative")
    private String narrative;
    @JsonProperty("qpf")
    private Integer qpf;
    @JsonProperty("snow_qpf")
    private Integer snowQpf;
    @JsonProperty("snow_range")
    private String snowRange;
    @JsonProperty("snow_phrase")
    private String snowPhrase;
    @JsonProperty("snow_code")
    private String snowCode;
    @JsonProperty("night")
    private Night night;
    @JsonProperty("day")
    private Day day;
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

    @JsonProperty("expire_time_gmt")
    public Integer getExpireTimeGmt() {
        return expireTimeGmt;
    }

    @JsonProperty("expire_time_gmt")
    public void setExpireTimeGmt(Integer expireTimeGmt) {
        this.expireTimeGmt = expireTimeGmt;
    }

    @JsonProperty("fcst_valid")
    public Integer getFcstValid() {
        return fcstValid;
    }

    @JsonProperty("fcst_valid")
    public void setFcstValid(Integer fcstValid) {
        this.fcstValid = fcstValid;
    }

    @JsonProperty("fcst_valid_local")
    public String getFcstValidLocal() {
        return fcstValidLocal;
    }

    @JsonProperty("fcst_valid_local")
    public void setFcstValidLocal(String fcstValidLocal) {
        this.fcstValidLocal = fcstValidLocal;
    }

    @JsonProperty("num")
    public Integer getNum() {
        return num;
    }

    @JsonProperty("num")
    public void setNum(Integer num) {
        this.num = num;
    }

    @JsonProperty("max_temp")
    public Integer getMaxTemp() {
        return maxTemp;
    }

    @JsonProperty("max_temp")
    public void setMaxTemp(Integer maxTemp) {
        this.maxTemp = maxTemp;
    }

    @JsonProperty("min_temp")
    public Integer getMinTemp() {
        return minTemp;
    }

    @JsonProperty("min_temp")
    public void setMinTemp(Integer minTemp) {
        this.minTemp = minTemp;
    }

    @JsonProperty("torcon")
    public Object getTorcon() {
        return torcon;
    }

    @JsonProperty("torcon")
    public void setTorcon(Object torcon) {
        this.torcon = torcon;
    }

    @JsonProperty("stormcon")
    public Object getStormcon() {
        return stormcon;
    }

    @JsonProperty("stormcon")
    public void setStormcon(Object stormcon) {
        this.stormcon = stormcon;
    }

    @JsonProperty("blurb")
    public Object getBlurb() {
        return blurb;
    }

    @JsonProperty("blurb")
    public void setBlurb(Object blurb) {
        this.blurb = blurb;
    }

    @JsonProperty("blurb_author")
    public Object getBlurbAuthor() {
        return blurbAuthor;
    }

    @JsonProperty("blurb_author")
    public void setBlurbAuthor(Object blurbAuthor) {
        this.blurbAuthor = blurbAuthor;
    }

    @JsonProperty("lunar_phase_day")
    public Integer getLunarPhaseDay() {
        return lunarPhaseDay;
    }

    @JsonProperty("lunar_phase_day")
    public void setLunarPhaseDay(Integer lunarPhaseDay) {
        this.lunarPhaseDay = lunarPhaseDay;
    }

    @JsonProperty("dow")
    public String getDow() {
        return dow;
    }

    @JsonProperty("dow")
    public void setDow(String dow) {
        this.dow = dow;
    }

    @JsonProperty("lunar_phase")
    public String getLunarPhase() {
        return lunarPhase;
    }

    @JsonProperty("lunar_phase")
    public void setLunarPhase(String lunarPhase) {
        this.lunarPhase = lunarPhase;
    }

    @JsonProperty("lunar_phase_code")
    public String getLunarPhaseCode() {
        return lunarPhaseCode;
    }

    @JsonProperty("lunar_phase_code")
    public void setLunarPhaseCode(String lunarPhaseCode) {
        this.lunarPhaseCode = lunarPhaseCode;
    }

    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("moonrise")
    public String getMoonrise() {
        return moonrise;
    }

    @JsonProperty("moonrise")
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    @JsonProperty("moonset")
    public String getMoonset() {
        return moonset;
    }

    @JsonProperty("moonset")
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    @JsonProperty("qualifier_code")
    public Object getQualifierCode() {
        return qualifierCode;
    }

    @JsonProperty("qualifier_code")
    public void setQualifierCode(Object qualifierCode) {
        this.qualifierCode = qualifierCode;
    }

    @JsonProperty("qualifier")
    public Object getQualifier() {
        return qualifier;
    }

    @JsonProperty("qualifier")
    public void setQualifier(Object qualifier) {
        this.qualifier = qualifier;
    }

    @JsonProperty("narrative")
    public String getNarrative() {
        return narrative;
    }

    @JsonProperty("narrative")
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    @JsonProperty("qpf")
    public Integer getQpf() {
        return qpf;
    }

    @JsonProperty("qpf")
    public void setQpf(Integer qpf) {
        this.qpf = qpf;
    }

    @JsonProperty("snow_qpf")
    public Integer getSnowQpf() {
        return snowQpf;
    }

    @JsonProperty("snow_qpf")
    public void setSnowQpf(Integer snowQpf) {
        this.snowQpf = snowQpf;
    }

    @JsonProperty("snow_range")
    public String getSnowRange() {
        return snowRange;
    }

    @JsonProperty("snow_range")
    public void setSnowRange(String snowRange) {
        this.snowRange = snowRange;
    }

    @JsonProperty("snow_phrase")
    public String getSnowPhrase() {
        return snowPhrase;
    }

    @JsonProperty("snow_phrase")
    public void setSnowPhrase(String snowPhrase) {
        this.snowPhrase = snowPhrase;
    }

    @JsonProperty("snow_code")
    public String getSnowCode() {
        return snowCode;
    }

    @JsonProperty("snow_code")
    public void setSnowCode(String snowCode) {
        this.snowCode = snowCode;
    }

    @JsonProperty("night")
    public Night getNight() {
        return night;
    }

    @JsonProperty("night")
    public void setNight(Night night) {
        this.night = night;
    }

    @JsonProperty("day")
    public Day getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Day day) {
        this.day = day;
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
