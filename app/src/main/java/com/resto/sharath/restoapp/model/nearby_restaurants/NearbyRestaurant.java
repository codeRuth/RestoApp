
package com.resto.sharath.restoapp.model.nearby_restaurants;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearbyRestaurant {

    @SerializedName("restaurant")
    @Expose
    private RestaurantDetails restaurant;

    public RestaurantDetails getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDetails restaurant) {
        this.restaurant = restaurant;
    }

}
