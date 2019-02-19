
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
@JsonPropertyOrder({ "fcst_valid", "fcst_valid_local", "day_ind", "thunder_enum", "daypart_name", "long_daypart_name", "alt_daypart_name",
        "thunder_enum_phrase", "num", "temp", "hi", "wc", "pop", "icon_extd", "icon_code", "wxman", "phrase_12char", "phrase_22char", "phrase_32char",
        "subphrase_pt1", "subphrase_pt2", "subphrase_pt3", "precip_type", "rh", "wspd", "wdir", "wdir_cardinal", "clds", "pop_phrase", "temp_phrase",
        "accumulation_phrase", "wind_phrase", "shortcast", "narrative", "qpf", "snow_qpf", "snow_range", "snow_phrase", "snow_code", "vocal_key",
        "qualifier_code", "qualifier", "uv_index_raw", "uv_index", "uv_warning", "uv_desc", "golf_index", "golf_category" })
public class Day {

    @JsonProperty("fcst_valid")
    private Integer fcstValid;
    @JsonProperty("fcst_valid_local")
    private String fcstValidLocal;
    @JsonProperty("day_ind")
    private String dayInd;
    @JsonProperty("thunder_enum")
    private Integer thunderEnum;
    @JsonProperty("daypart_name")
    private String daypartName;
    @JsonProperty("long_daypart_name")
    private String longDaypartName;
    @JsonProperty("alt_daypart_name")
    private String altDaypartName;
    @JsonProperty("thunder_enum_phrase")
    private Object thunderEnumPhrase;
    @JsonProperty("num")
    private Integer num;
    @JsonProperty("temp")
    private Integer temp;
    @JsonProperty("hi")
    private Integer hi;
    @JsonProperty("wc")
    private Integer wc;
    @JsonProperty("pop")
    private Integer pop;
    @JsonProperty("icon_extd")
    private Integer iconExtd;
    @JsonProperty("icon_code")
    private Integer iconCode;
    @JsonProperty("wxman")
    private String wxman;
    @JsonProperty("phrase_12char")
    private String phrase12char;
    @JsonProperty("phrase_22char")
    private String phrase22char;
    @JsonProperty("phrase_32char")
    private String phrase32char;
    @JsonProperty("subphrase_pt1")
    private String subphrasePt1;
    @JsonProperty("subphrase_pt2")
    private String subphrasePt2;
    @JsonProperty("subphrase_pt3")
    private String subphrasePt3;
    @JsonProperty("precip_type")
    private String precipType;
    @JsonProperty("rh")
    private Integer rh;
    @JsonProperty("wspd")
    private Integer wspd;
    @JsonProperty("wdir")
    private Integer wdir;
    @JsonProperty("wdir_cardinal")
    private String wdirCardinal;
    @JsonProperty("clds")
    private Integer clds;
    @JsonProperty("pop_phrase")
    private String popPhrase;
    @JsonProperty("temp_phrase")
    private String tempPhrase;
    @JsonProperty("accumulation_phrase")
    private String accumulationPhrase;
    @JsonProperty("wind_phrase")
    private String windPhrase;
    @JsonProperty("shortcast")
    private String shortcast;
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
    @JsonProperty("vocal_key")
    private String vocalKey;
    @JsonProperty("qualifier_code")
    private Object qualifierCode;
    @JsonProperty("qualifier")
    private String qualifier;
    @JsonProperty("uv_index_raw")
    private Double uvIndexRaw;
    @JsonProperty("uv_index")
    private Integer uvIndex;
    @JsonProperty("uv_warning")
    private Integer uvWarning;
    @JsonProperty("uv_desc")
    private String uvDesc;
    @JsonProperty("golf_index")
    private Integer golfIndex;
    @JsonProperty("golf_category")
    private String golfCategory;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

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

    @JsonProperty("day_ind")
    public String getDayInd() {
        return dayInd;
    }

    @JsonProperty("day_ind")
    public void setDayInd(String dayInd) {
        this.dayInd = dayInd;
    }

    @JsonProperty("thunder_enum")
    public Integer getThunderEnum() {
        return thunderEnum;
    }

    @JsonProperty("thunder_enum")
    public void setThunderEnum(Integer thunderEnum) {
        this.thunderEnum = thunderEnum;
    }

    @JsonProperty("daypart_name")
    public String getDaypartName() {
        return daypartName;
    }

    @JsonProperty("daypart_name")
    public void setDaypartName(String daypartName) {
        this.daypartName = daypartName;
    }

    @JsonProperty("long_daypart_name")
    public String getLongDaypartName() {
        return longDaypartName;
    }

    @JsonProperty("long_daypart_name")
    public void setLongDaypartName(String longDaypartName) {
        this.longDaypartName = longDaypartName;
    }

    @JsonProperty("alt_daypart_name")
    public String getAltDaypartName() {
        return altDaypartName;
    }

    @JsonProperty("alt_daypart_name")
    public void setAltDaypartName(String altDaypartName) {
        this.altDaypartName = altDaypartName;
    }

    @JsonProperty("thunder_enum_phrase")
    public Object getThunderEnumPhrase() {
        return thunderEnumPhrase;
    }

    @JsonProperty("thunder_enum_phrase")
    public void setThunderEnumPhrase(Object thunderEnumPhrase) {
        this.thunderEnumPhrase = thunderEnumPhrase;
    }

    @JsonProperty("num")
    public Integer getNum() {
        return num;
    }

    @JsonProperty("num")
    public void setNum(Integer num) {
        this.num = num;
    }

    @JsonProperty("temp")
    public Integer getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    @JsonProperty("hi")
    public Integer getHi() {
        return hi;
    }

    @JsonProperty("hi")
    public void setHi(Integer hi) {
        this.hi = hi;
    }

    @JsonProperty("wc")
    public Integer getWc() {
        return wc;
    }

    @JsonProperty("wc")
    public void setWc(Integer wc) {
        this.wc = wc;
    }

    @JsonProperty("pop")
    public Integer getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    @JsonProperty("icon_extd")
    public Integer getIconExtd() {
        return iconExtd;
    }

    @JsonProperty("icon_extd")
    public void setIconExtd(Integer iconExtd) {
        this.iconExtd = iconExtd;
    }

    @JsonProperty("icon_code")
    public Integer getIconCode() {
        return iconCode;
    }

    @JsonProperty("icon_code")
    public void setIconCode(Integer iconCode) {
        this.iconCode = iconCode;
    }

    @JsonProperty("wxman")
    public String getWxman() {
        return wxman;
    }

    @JsonProperty("wxman")
    public void setWxman(String wxman) {
        this.wxman = wxman;
    }

    @JsonProperty("phrase_12char")
    public String getPhrase12char() {
        return phrase12char;
    }

    @JsonProperty("phrase_12char")
    public void setPhrase12char(String phrase12char) {
        this.phrase12char = phrase12char;
    }

    @JsonProperty("phrase_22char")
    public String getPhrase22char() {
        return phrase22char;
    }

    @JsonProperty("phrase_22char")
    public void setPhrase22char(String phrase22char) {
        this.phrase22char = phrase22char;
    }

    @JsonProperty("phrase_32char")
    public String getPhrase32char() {
        return phrase32char;
    }

    @JsonProperty("phrase_32char")
    public void setPhrase32char(String phrase32char) {
        this.phrase32char = phrase32char;
    }

    @JsonProperty("subphrase_pt1")
    public String getSubphrasePt1() {
        return subphrasePt1;
    }

    @JsonProperty("subphrase_pt1")
    public void setSubphrasePt1(String subphrasePt1) {
        this.subphrasePt1 = subphrasePt1;
    }

    @JsonProperty("subphrase_pt2")
    public String getSubphrasePt2() {
        return subphrasePt2;
    }

    @JsonProperty("subphrase_pt2")
    public void setSubphrasePt2(String subphrasePt2) {
        this.subphrasePt2 = subphrasePt2;
    }

    @JsonProperty("subphrase_pt3")
    public String getSubphrasePt3() {
        return subphrasePt3;
    }

    @JsonProperty("subphrase_pt3")
    public void setSubphrasePt3(String subphrasePt3) {
        this.subphrasePt3 = subphrasePt3;
    }

    @JsonProperty("precip_type")
    public String getPrecipType() {
        return precipType;
    }

    @JsonProperty("precip_type")
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    @JsonProperty("rh")
    public Integer getRh() {
        return rh;
    }

    @JsonProperty("rh")
    public void setRh(Integer rh) {
        this.rh = rh;
    }

    @JsonProperty("wspd")
    public Integer getWspd() {
        return wspd;
    }

    @JsonProperty("wspd")
    public void setWspd(Integer wspd) {
        this.wspd = wspd;
    }

    @JsonProperty("wdir")
    public Integer getWdir() {
        return wdir;
    }

    @JsonProperty("wdir")
    public void setWdir(Integer wdir) {
        this.wdir = wdir;
    }

    @JsonProperty("wdir_cardinal")
    public String getWdirCardinal() {
        return wdirCardinal;
    }

    @JsonProperty("wdir_cardinal")
    public void setWdirCardinal(String wdirCardinal) {
        this.wdirCardinal = wdirCardinal;
    }

    @JsonProperty("clds")
    public Integer getClds() {
        return clds;
    }

    @JsonProperty("clds")
    public void setClds(Integer clds) {
        this.clds = clds;
    }

    @JsonProperty("pop_phrase")
    public String getPopPhrase() {
        return popPhrase;
    }

    @JsonProperty("pop_phrase")
    public void setPopPhrase(String popPhrase) {
        this.popPhrase = popPhrase;
    }

    @JsonProperty("temp_phrase")
    public String getTempPhrase() {
        return tempPhrase;
    }

    @JsonProperty("temp_phrase")
    public void setTempPhrase(String tempPhrase) {
        this.tempPhrase = tempPhrase;
    }

    @JsonProperty("accumulation_phrase")
    public String getAccumulationPhrase() {
        return accumulationPhrase;
    }

    @JsonProperty("accumulation_phrase")
    public void setAccumulationPhrase(String accumulationPhrase) {
        this.accumulationPhrase = accumulationPhrase;
    }

    @JsonProperty("wind_phrase")
    public String getWindPhrase() {
        return windPhrase;
    }

    @JsonProperty("wind_phrase")
    public void setWindPhrase(String windPhrase) {
        this.windPhrase = windPhrase;
    }

    @JsonProperty("shortcast")
    public String getShortcast() {
        return shortcast;
    }

    @JsonProperty("shortcast")
    public void setShortcast(String shortcast) {
        this.shortcast = shortcast;
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

    @JsonProperty("vocal_key")
    public String getVocalKey() {
        return vocalKey;
    }

    @JsonProperty("vocal_key")
    public void setVocalKey(String vocalKey) {
        this.vocalKey = vocalKey;
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
    public String getQualifier() {
        return qualifier;
    }

    @JsonProperty("qualifier")
    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    @JsonProperty("uv_index_raw")
    public Double getUvIndexRaw() {
        return uvIndexRaw;
    }

    @JsonProperty("uv_index_raw")
    public void setUvIndexRaw(Double uvIndexRaw) {
        this.uvIndexRaw = uvIndexRaw;
    }

    @JsonProperty("uv_index")
    public Integer getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uv_index")
    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("uv_warning")
    public Integer getUvWarning() {
        return uvWarning;
    }

    @JsonProperty("uv_warning")
    public void setUvWarning(Integer uvWarning) {
        this.uvWarning = uvWarning;
    }

    @JsonProperty("uv_desc")
    public String getUvDesc() {
        return uvDesc;
    }

    @JsonProperty("uv_desc")
    public void setUvDesc(String uvDesc) {
        this.uvDesc = uvDesc;
    }

    @JsonProperty("golf_index")
    public Integer getGolfIndex() {
        return golfIndex;
    }

    @JsonProperty("golf_index")
    public void setGolfIndex(Integer golfIndex) {
        this.golfIndex = golfIndex;
    }

    @JsonProperty("golf_category")
    public String getGolfCategory() {
        return golfCategory;
    }

    @JsonProperty("golf_category")
    public void setGolfCategory(String golfCategory) {
        this.golfCategory = golfCategory;
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
