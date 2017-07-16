package io.bachirio.pokemonapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import io.bachirio.pokemonapp.models.Pokemons;

public class MainActivity extends AppCompatActivity implements PokemonRequest.ResponseListener<Pokemons> {

    private static String TAG = MainActivity.class.getName();
    private RecyclerView mPokemonRecyclerView;
    private RequestQueue queue;
    private Pokemons pokemons;
    private Boolean isFirstcall;
    private PokemonAdapter mPokemonAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPokemonRecyclerView = (RecyclerView) findViewById(R.id.pokemon_recyclerview);
        // Setting a scroll listener for the recycler view
        mPokemonRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int[] lastCompletelyVisibleItems = new int[3];
                    mStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(lastCompletelyVisibleItems);
                    Log.d(TAG,"lastCompletelyVisibleItems"+lastCompletelyVisibleItems[0]+" -1-"+lastCompletelyVisibleItems[1]+"-2-"+lastCompletelyVisibleItems[2]);
                        loadMore();
                }
            }
        });

        sendFirstRequest();


        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mPokemonRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);


    }

    private void loadMore() {
    }


    private void sendFirstRequest() {
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);

        PokemonRequest pokemonRequest = new PokemonRequest(PokemonRequest.POKEMON_URL, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.getMessage());
            }
        });

        pokemonRequest.setResponseListener(this);
        // Add the request to the RequestQueue.
        queue.add(pokemonRequest);
    }

    @Override
    public void onResponse(Pokemons response) {
        if (response instanceof Pokemons){
            pokemons =  response;

            updateUI();

        }

    }

    private void updateUI() {
        mPokemonAdapter =new PokemonAdapter(pokemons.getResults());
        mPokemonRecyclerView.setAdapter(mPokemonAdapter);

    }


}
