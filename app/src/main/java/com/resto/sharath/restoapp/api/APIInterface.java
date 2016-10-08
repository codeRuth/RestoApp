package com.resto.sharath.restoapp.api;

import com.resto.sharath.restoapp.model.RestaurantResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @Headers("user-key: 9671c458ff47cf76f76c63285ed8dd94")
    @GET("geocode")
    Call<RestaurantResponse> getNearbyRestaurants(
            @Query("lat") Double latitude,
            @Query("lon") Double longitude
    );

//    @GET("movie/{id}")
//    Call<AMoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}