package io.bachirio.pokemonapp;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import io.bachirio.pokemonapp.models.Pokemons;

/**
 * Created by bachiri on 3/20/17.
 */

public class PokemonRequest extends Request<Pokemons> {

    public static String POKEMON_URL = "http://pokeapi.co/api/v2/pokemon/";
    private ResponseListener<Pokemons> responseListener;




    public PokemonRequest(String url, Response.ErrorListener listener) {
        super(Method.GET, url, listener);

    }

    @Override
    protected Response<Pokemons> parseNetworkResponse(NetworkResponse response) {
        Pokemons pokemons;
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            ObjectMapper mapper = new ObjectMapper();

            pokemons = mapper.readValue(json, Pokemons.class);
            return Response.success(pokemons,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (IOException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }


    }


    @Override
    protected void deliverResponse(Pokemons response) {
        if (responseListener != null)
            responseListener.onResponse(response);

    }


    public void setResponseListener(ResponseListener<Pokemons> responseListener) {
        this.responseListener = responseListener;
    }
    public interface ResponseListener<T> {
        void onResponse(T t);
    }




}
