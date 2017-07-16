package io.bachirio.pokemonapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by bachiri on 3/20/17.
 */


/**
 * This class is for the Lists of pokemons
 */
public class Pokemons {

    @JsonProperty("count")
    private int count;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    List<Pokemon> results;

    @JsonProperty("next")
    private String next;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
