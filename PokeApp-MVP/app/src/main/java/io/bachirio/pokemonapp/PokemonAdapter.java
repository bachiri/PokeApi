package io.bachirio.pokemonapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.bachirio.pokemonapp.models.Pokemon;

/**
 * Created by bachiri on 3/20/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonHolder> {

    List<Pokemon> pokemons;


    public PokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_list_item, parent, false);
        return new PokemonHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PokemonHolder holder, int position) {

        Pokemon itemPokemon = pokemons.get(position);
        holder.bindPokemon(itemPokemon,position);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
