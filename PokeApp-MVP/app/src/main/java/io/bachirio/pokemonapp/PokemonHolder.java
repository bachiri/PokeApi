package io.bachirio.pokemonapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.bachirio.pokemonapp.models.Pokemon;

/**
 * Created by bachiri on 3/20/17.
 */

public class PokemonHolder extends RecyclerView.ViewHolder {

    private ImageView pokemonimage;
    private TextView pokemonname;
    private Pokemon mPokemon;
    public static final String IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

    public PokemonHolder(View itemView) {
        super(itemView);

        pokemonimage = (ImageView) itemView.findViewById(R.id.pokemon_image);
        pokemonname = (TextView) itemView.findViewById(R.id.pokemon_name);
    }

    public void bindPokemon(Pokemon Pokemon,int position) {
        mPokemon = Pokemon;

        Picasso.with(pokemonimage.getContext()).load(IMAGE_URL +(position+1)+".png").into(pokemonimage);

        pokemonname.setText(mPokemon.getName());

    }
}
