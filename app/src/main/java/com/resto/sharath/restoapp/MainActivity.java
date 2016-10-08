package com.resto.sharath.restoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.resto.sharath.restoapp.adapter.RestaurantAdapter;
import com.resto.sharath.restoapp.api.APIClient;
import com.resto.sharath.restoapp.api.APIInterface;
import com.resto.sharath.restoapp.model.RestaurantResponse;
import com.resto.sharath.restoapp.model.nearby_restaurants.NearbyRestaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    // TODO - insert your themoviedb.org API KEY here
    // private final static String API_KEY = "c7bdba2e30c9485ed05e33c451cf52e1";
    private final double latitude = 12.9102579;
    private final double longitude = 77.6281079;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (API_KEY.isEmpty()) {
//            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
//            return;
//        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);

        Call<RestaurantResponse> call = apiService.getNearbyRestaurants(latitude, longitude);
        call.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                int statusCode = response.code();
                List<NearbyRestaurant> movies = response.body().getNearbyRestaurants();
                recyclerView.setAdapter(new RestaurantAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}