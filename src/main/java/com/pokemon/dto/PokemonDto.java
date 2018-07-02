package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;




@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDto {
    private String name;
    private String weight;
    private String speciesUrl;
    private String speciesName;

    @JsonProperty("abilities")
    private AbilitiesDto[] abilities;


    @JsonProperty("stats")
    private StatsDto[] statsDto;

    public PokemonDto() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public PokemonDto(String name, String weight) {
        this.name = name;
        this.weight = weight;

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("species")
    private void unpackNested(Map<String, Object> spec) {
        this.speciesName = (String) spec.get("name");
        this.speciesUrl = (String) spec.get("url");
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getSpeciesUrl() {
        return speciesUrl;
    }

    public void setSpeciesUrl(String speciesUrl) {
        this.speciesUrl = speciesUrl;
    }

    @Override
    public String toString() {
        return "PokemonDto{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", speciesUrl='" + speciesUrl + '\'' +
                ", speciesName='" + speciesName + '\'' +
                ", abilities=" + Arrays.toString(abilities) +
                '}';
    }

}
