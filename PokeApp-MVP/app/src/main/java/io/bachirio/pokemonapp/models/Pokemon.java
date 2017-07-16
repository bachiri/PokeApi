package io.bachirio.pokemonapp.models;

/**
 * Created by bachiri on 3/20/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is a temporary class for pokemons we can say it's the minimised version
 */
public class Pokemon {

    @JsonProperty("url")
    private String url;

    @JsonProperty("name")
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
