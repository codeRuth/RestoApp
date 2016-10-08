package com.resto.sharath.restoapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.resto.sharath.restoapp.R;
import com.resto.sharath.restoapp.model.nearby_restaurants.NearbyRestaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private List<NearbyRestaurant> restaurant;
    private int rowLayout;
    private Context context;


    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        LinearLayout restaurantLayout;
        TextView restaurantTitle;
        TextView cuisines;
        TextView restaurantAddress;
        TextView rating;


        public RestaurantViewHolder(View v) {
            super(v);
            restaurantLayout = (LinearLayout) v.findViewById(R.id.restaurant_layout);
            restaurantTitle = (TextView) v.findViewById(R.id.title);
            cuisines = (TextView) v.findViewById(R.id.cuisines);
            restaurantAddress = (TextView) v.findViewById(R.id.address);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public RestaurantAdapter(List<NearbyRestaurant> restaurant, int rowLayout, Context context) {
        this.restaurant = restaurant;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RestaurantViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, final int position) {
        holder.restaurantTitle.setText(restaurant.get(position).getRestaurant().getName());
        holder.restaurantAddress.setText(restaurant.get(position).getRestaurant().getLocation().getAddress());
        holder.cuisines.setText(restaurant.get(position).getRestaurant().getCuisines());
        holder.rating.setText(restaurant.get(position).getRestaurant().getUserRating().getAggregateRating());
    }

    @Override
    public int getItemCount() {
        return restaurant.size();
    }
}
